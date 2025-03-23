package com.tuna.gomen.report.mybatis.controller;

import com.tuna.gomen.report.mybatis.model.Report;
import com.tuna.gomen.report.mybatis.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 이름 지정해서 빈 충돌 방지
@RestController("mybatisReportController")
@RequestMapping("/gomen/reports")
@RequiredArgsConstructor
public class ReportController {

    @Qualifier("mybatisReportService") // 서비스도 이름 명시해야 함
    private final ReportService reportService;

    @GetMapping("/processed")
    public List<Report> getProcessedReportsWithUser() {
        return reportService.getProcessedReportsWithUser();
    }
}

