// 📁 com.tuna.gomen.report.mybatis.service

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

    public List<Report> getProcessedReportsWithUser() {
        return reportMapper.getProcessedReportsWithUser();
    }
}
