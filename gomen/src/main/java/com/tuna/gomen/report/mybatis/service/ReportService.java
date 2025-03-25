package com.tuna.gomen.report.mybatis.service;

import com.tuna.gomen.mapper.ReportMapper;
import com.tuna.gomen.report.mybatis.model.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mybatisReportService")
@RequiredArgsConstructor
public class ReportService {
    private final ReportMapper reportMapper;

    // 처린된 신고 조회
    public List<Report> getProcessedReportsWithUser() {
        return reportMapper.getProcessedReportsWithUser();
    }

    // 특정 게시글에 대한 신고 조회
    public List<Report> selectReportsByPostId(int postId) {
        return reportMapper.selectReportsByPostId(postId);
    }

    // 특정 사용자에 대한 신고 조회
    public List<Report> selectReportsByUserId(int userId) {
        return reportMapper.selectReportsByUserId(userId);
    }

    // 신고한 회원에 대한 신고 조회
    public List<Report> selectReportsByReportingMemberId(int reportingMemberId) {
        return reportMapper.selectReportsByReportingMemberId(reportingMemberId);
    }

    // 특정 신고 유형에 대한 신고 조회
    public List<Report> selectReportsByViolationId(int violationId) {
        return reportMapper.selectReportsByViolationId(violationId);
    }

    // 신고 처리 여부에 따른 신고 조회
    public List<Report> selectReportsByStatus(String status) {
        return reportMapper.selectReportsByStatus(status);
    }
}
