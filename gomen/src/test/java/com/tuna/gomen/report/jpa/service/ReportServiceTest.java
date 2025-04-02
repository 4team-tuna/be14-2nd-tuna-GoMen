package com.tuna.gomen.report.jpa.service;

import static org.junit.jupiter.api.Assertions.*;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.comment.command.entity.Comment;
import com.tuna.gomen.comment.command.repository.CommentRepository;
import com.tuna.gomen.report.jpa.entity.Report;
import com.tuna.gomen.report.jpa.entity.ReportCategory;
import com.tuna.gomen.report.jpa.repository.ReportCategoryRepository;
import com.tuna.gomen.report.jpa.repository.ReportRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BoardRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private ReportCategoryRepository categoryRepository;

    @InjectMocks
    private ReportService reportService;

    private User user;
    private Report report;
    private ReportCategory reportCategory;
    private Board board;
    private Comment comment;

    @BeforeEach
    public void setUp() {
        // 사용자 설정
        user = new User();
        user.setUserId(1);
        user.setViolationScore(95);  // 기존 점수 95점
        user.setIsQuitted("N");     // 영구정지되지 않음

        // 신고 카테고리 설정
        reportCategory = new ReportCategory();
        reportCategory.setMinusPoint(10);  // 벌점 10점

        // 신고 설정
        report = new Report();
        report.setReportId(1);
        report.setIsProcessed("N");
        report.setViolation(reportCategory);
        report.setReportTargetUserId(1);  // 신고 대상 사용자 ID
        report.setReportTargetPostId(1);  // 신고 대상 게시글 ID

        // 게시글 설정
        board = new Board();
        board.setPostId(1);
        board.setIsBlinded("N");
        board.setUser(user);  // 게시글 작성자 설정

        // 댓글 설정
        comment = new Comment();
        comment.setId(1);
        comment.setIsBlinded("N");
        comment.setUser(user);  // 댓글 작성자 설정
        comment.setBoard(board);  // 게시글과 댓글 연관 설정
    }

    @Test
    @Transactional
    public void 신고_처리_점수_100점_이상시_영구정지_처리() {
        // given
        when(reportRepository.findById(1)).thenReturn(Optional.of(report));
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(postRepository.findById(1)).thenReturn(Optional.of(board));

        // when
        Report processedReport = reportService.processReport(1);

        // then
        assertEquals("Y", processedReport.getIsProcessed());  // 신고 처리 상태 Y
        assertEquals("Y", user.getIsQuitted());  // 점수 100점 이상 후 영구 정지
        assertTrue(user.getViolationScore() >= 100);  // 점수는 100점 이상이어야 함
        verify(userRepository, times(1)).save(user);  // 사용자 저장 검증
        verify(postRepository, times(1)).save(board);  // 게시글 저장 검증
    }

//    @Test
//    @Transactional
//    public void 신고_처리_게시글_블라인드_처리() {
//        // given
//        report.setReportTargetPostId(1);  // 신고 대상 게시글
//        when(reportRepository.findById(1)).thenReturn(Optional.of(report));
//        when(postRepository.findById(1)).thenReturn(Optional.of(board));
//
//        // when
//        reportService.processReport(1);
//
//        // then
//        assertEquals("Y", board.getIsBlinded());  // 게시글이 블라인드 처리되어야 함
//        verify(postRepository, times(1)).save(board);  // 게시글 저장 검증
//    }
//
//    @Test
//    @Transactional
//    public void 신고_처리_댓글_블라인드_처리() {
//        // given
//        report.setCommentId(1);  // 신고 대상 댓글
//        when(reportRepository.findById(1)).thenReturn(Optional.of(report));  // 신고 리포트 Mock 설정
//        when(commentRepository.findById(1)).thenReturn(Optional.of(comment));  // 댓글 리포트 Mock 설정
//
//        // when
//        reportService.processReport(1);  // 신고 처리
//
//        // then
//        assertEquals("Y", comment.getIsBlinded());  // 댓글이 블라인드 처리되어야 함
//        verify(commentRepository, times(1)).save(comment);  // 댓글 저장 검증
//    }

    @Test
    @Transactional
    public void 신고_처리_이미_처리된_신고() {
        // given
        report.setIsProcessed("Y");  // 이미 처리된 신고
        when(reportRepository.findById(1)).thenReturn(Optional.of(report));

        // when
        Report processedReport = reportService.processReport(1);

        // then
        assertEquals("Y", processedReport.getIsProcessed());  // 신고 상태는 여전히 "Y"
        verify(userRepository, times(0)).save(any());  // 사용자는 업데이트되지 않아야 함
        verify(postRepository, times(0)).save(any());  // 게시글도 업데이트되지 않아야 함
    }
}
