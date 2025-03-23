package com.tuna.gomen.report.jpa.dto;

import lombok.Data;

@Data
public class ReportDto {
    private Integer posterId;
    private Integer reportTargetPostId;
    private Integer reportTargetUserId;
    private Integer commentId;
    private String reportContent;
    private Integer violationId;
}