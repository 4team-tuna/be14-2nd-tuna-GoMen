package com.tuna.gomen.report.jpa.service;

import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.comment.command.repository.CommentRepository;
import com.tuna.gomen.report.jpa.dto.ReportDto;
import com.tuna.gomen.report.jpa.entity.Report;
import com.tuna.gomen.report.jpa.entity.ReportCategory;
import com.tuna.gomen.report.jpa.repository.ReportCategoryRepository;
import com.tuna.gomen.report.jpa.repository.ReportRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("jpaReportService")
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportCategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final BoardRepository postRepository;
    private final CommentRepository commentRepository;

    public Report createReport(Report report) {
        report.setCreatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    public void createReport(ReportDto dto) {
        Report report = new Report();
        report.setPosterId(dto.getPosterId());
        report.setReportContent(dto.getReportContent());
        report.setCommentId(dto.getCommentId());
        report.setReportTargetPostId(dto.getReportTargetPostId());
        report.setReportTargetUserId(dto.getReportTargetUserId());

        ReportCategory category = categoryRepository
                .findById(dto.getViolationId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 신고 사유입니다."));
        report.setViolation(category);

        reportRepository.save(report);
    }

    public List<Report> getProcessedReports() {
        return reportRepository.findByIsProcessed("Y");
    }

    public List<Report> getUnprocessedReports() {
        return reportRepository.findByIsProcessed("N");
    }

    //신고 처리: 벌점 부여 + 블라인드 처리 포함(게시글, 댓글 둘 다)
    @Transactional
    public Report processReport(int reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("신고 내역 없음"));

        if ("N".equals(report.getIsProcessed())) {
            report.setIsProcessed("Y");
            report.setIsProcessedTime(LocalDateTime.now());

            int minus = report.getViolation().getMinusPoint();
            Integer targetId = Optional.ofNullable(report.getReportTargetUserId())
                    .orElseGet(() -> getTargetUserIdByPostOrComment(report));

            if (targetId != null) {
                User user = userRepository.findById(targetId).orElseThrow();
                int updatedScore = user.getViolationScore() + minus;
                user.setViolationScore(updatedScore);
                if (updatedScore >= 100) {
                    user.setIsQuitted("Y");
                }
                userRepository.save(user);
            }

            // 블라인드 처리
            blindTargetPostOrComment(report);

            reportRepository.save(report);
        }

        return report;
    }

    // 게시글 또는 댓글 작성자 ID를 추출
    private Integer getTargetUserIdByPostOrComment(Report report) {
        if (report.getReportTargetPostId() != null) {
            return postRepository.findById(report.getReportTargetPostId())
                    .map(post -> post.getWriterId())
                    .orElse(null);
        }

        if (report.getCommentId() != null) {
            return commentRepository.findById(report.getCommentId())
                    .map(comment -> comment.getWriterId())
                    .orElse(null);
        }

        return null;
    }


    // 게시글 또는 댓글 블라인드 처리
    private void blindTargetPostOrComment(Report report) {
        if (report.getReportTargetPostId() != null) {
            postRepository.findById(report.getReportTargetPostId())
                    .ifPresent(post -> {
                        post.setIsBlinded("Y");
                        postRepository.save(post);
                    });
        }

        if (report.getCommentId() != null) {
            commentRepository.findById(report.getCommentId())
                    .ifPresent(comment -> {
                        comment.setIsBlinded("Y");
                        commentRepository.save(comment);
                    });
        }
    }
}
