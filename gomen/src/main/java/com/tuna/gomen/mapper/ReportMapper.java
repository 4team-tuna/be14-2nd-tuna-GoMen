package com.tuna.gomen.mapper;

import com.tuna.gomen.report.Report;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReportMapper {
    List<Report> getProcessedReportsWithUser();  // XML에서 실행됨
}
