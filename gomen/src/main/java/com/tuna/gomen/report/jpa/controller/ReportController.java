package com.tuna.gomen.report.jpa.controller;

import com.tuna.gomen.report.jpa.dto.ReportDto;
import com.tuna.gomen.report.jpa.entity.Report;
import com.tuna.gomen.report.jpa.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/report")
@RequiredArgsConstructor
public class ReportController {

    @Qualifier("jpaReportService")
    private final ReportService reportService;


    @PostMapping
    public ResponseEntity<?> createReport(@RequestBody ReportDto reportDto) {
        reportService.createReport(reportDto);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{reportId}/process")
    public ResponseEntity<Report> processReport(@PathVariable int reportId) {
        return ResponseEntity.ok(reportService.processReport(reportId));
    }
}
