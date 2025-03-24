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

    private int userId;
    private String loginId;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String isMentor;
    private String reporterNickname;
    private String reportedNickname;
}