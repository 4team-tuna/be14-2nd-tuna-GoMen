package com.tuna.gomen.report.mybatis.controller;

import com.tuna.gomen.report.mybatis.model.Report;
import com.tuna.gomen.report.mybatis.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("mybatisReportController")
@RequestMapping("/gomen/reports")
@RequiredArgsConstructor
public class ReportController {

    @Qualifier("mybatisReportService") // 서비스도 이름 명시해야 함
    private final ReportService reportService;

    // 신고된 처리된 보고서 조회 - 확인 완료
    //http://localhost:8080/gomen/reports/processed
    @GetMapping("/processed")
    public List<Report> getProcessedReportsWithUser() {
        return reportService.getProcessedReportsWithUser();
    }

    // 특정 게시글에 대한 신고 조회(타겟 게시글)
    //http://localhost:8080/gomen/reports/post/1
    @GetMapping("/post/{postId}")
    public List<Report> getReportsByPostId(@PathVariable int postId) {
        return reportService.selectReportsByPostId(postId);
    }

    // 특정 사용자에 대한 신고 조회(타켓 유저)
    //http://localhost:8080/gomen/reports/user/50
    @GetMapping("/user/{posterId}")
    public List<Report> getReportsByUserId(@PathVariable int posterId) {
        return reportService.selectReportsByUserId(posterId);
    }

    // 신고한 회원에 대한 신고 조회(신고한 사람)
    //http://localhost:8080/gomen/reports/reportingMember/5
    @GetMapping("/reportingMember/{reportingMemberId}")
    public List<Report> getReportsByReportingMemberId(@PathVariable int reportingMemberId) {
        return reportService.selectReportsByReportingMemberId(reportingMemberId);
    }

    // 특정 신고 유형에 대한 신고 조회
    //http://localhost:8080/gomen/reports/violation/3
    @GetMapping("/violation/{violationId}")
    public List<Report> getReportsByViolationId(@PathVariable int violationId) {
        return reportService.selectReportsByViolationId(violationId);
    }

    // 신고 처리 여부에 따른 신고 조회
    //http://localhost:8080/gomen/reports/status/Y
    //http://localhost:8080/gomen/reports/status/N
    @GetMapping("/status/{status}")
    public List<Report> getReportsByStatus(@PathVariable String status) {
        return reportService.selectReportsByStatus(status);
    }
}
