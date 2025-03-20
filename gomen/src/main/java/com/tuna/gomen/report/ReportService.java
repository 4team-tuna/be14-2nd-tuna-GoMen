package com.tuna.gomen.report;

import com.tuna.gomen.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportMapper reportMapper;

    public List<Report> getProcessedReportsWithUser() {
        return reportMapper.getProcessedReportsWithUser();
    }
}

