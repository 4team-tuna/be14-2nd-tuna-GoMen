package com.tuna.gomen.mapper;

import com.tuna.gomen.report.mybatis.model.Report;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReportMapper {
    List<Report> getProcessedReportsWithUser();

    List<Report> selectReportsByPostId(int postId);

    List<Report> selectReportsByUserId(int userId);

    List<Report> selectReportsByReportingMemberId(int reportingMemberId);

    List<Report> selectReportsByViolationId(int violationId);

    List<Report> selectReportsByStatus(String status);
}
