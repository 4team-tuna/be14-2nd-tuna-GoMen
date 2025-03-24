// 📁 com.tuna.gomen.report.jpa.service

package com.tuna.gomen.report.jpa.service;

import com.tuna.gomen.report.jpa.dto.ReportDto;
import com.tuna.gomen.report.jpa.entity.Report;
import com.tuna.gomen.report.jpa.entity.ReportCategory;
import com.tuna.gomen.report.jpa.repository.ReportCategoryRepository;
import com.tuna.gomen.report.jpa.repository.ReportRepository;
import com.tuna.gomen.user.command.entity.UserEntity;
import com.tuna.gomen.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("jpaReportService")
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportCategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public Report createReport(Report report) {
        report.setCreatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    public List<Report> getProcessedReports() {
        return reportRepository.findByIsProcessed("Y");
    }

    public List<Report> getUnprocessedReports() {
        return reportRepository.findByIsProcessed("N");
    }

    public Report processReport(int reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("신고 내역 없음"));

        report.setIsProcessed("Y");
        report.setIsProcessedTime(LocalDateTime.now());

        int minus = report.getViolation().getMinusPoint();
        Integer targetId = Optional.ofNullable(report.getReportTargetUserId())
                .orElseGet(() -> getTargetUserIdByPostOrComment(report));

        if (targetId != null) {
            UserEntity user = userRepository.findById(targetId).orElseThrow();
            int updatedScore = user.getViolationScore() + minus;
            user.setViolationScore(updatedScore);
            if (updatedScore >= 100) {
                user.setIsQuitted("Y");
            }
            userRepository.save(user);
        }

        return reportRepository.save(report);
    }

    private Integer getTargetUserIdByPostOrComment(Report report) {
        // TODO: 게시글/댓글 작성자 조회 로직 필요
        return null;
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
}
