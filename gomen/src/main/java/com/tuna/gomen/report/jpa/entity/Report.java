package com.tuna.gomen.report.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_report")
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    private String reportContent;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String isProcessed = "N";
    private LocalDateTime isProcessedTime;
    private Integer posterId;
    private Integer reportTargetPostId;
    private Integer reportTargetUserId;
    private Integer commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "violation_id", nullable = false)
    private ReportCategory violation;
}