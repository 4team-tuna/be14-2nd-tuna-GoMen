package com.tuna.gomen.report.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Report {
    private int reportId;
    private String reportContent;
    private LocalDateTime createdAt;
    private String isProcessed;
    private LocalDateTime isProcessedTime;
    private int posterId;
    private Integer reportTargetPostId;
    private Integer reportTargetUserId;
    private Integer commentId;
    private int violationId;

    // 사용자 식별 정보는 nickname만 사용
    private String reporterNickname;
    private String reportedNickname;

    // 신고 사유 카테고리
    private String violationCategory;
}
