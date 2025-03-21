package com.tuna.gomen.report;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/processed")
    public List<Report> getProcessedReportsWithUser() {
        return reportService.getProcessedReportsWithUser();
    }
}


