package com.tuna.gomen.report;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReportMapper {
    List<Report> getProcessedReportsWithUser();  // XML에서 실행됨
}
