package com.tuna.gomen.report;

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

    // 회원 정보 추가
    private int userId;
    private String loginId;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String isMentor;

    // 🚨 추가: 신고한 회원 닉네임 & 신고 대상 회원 닉네임
    private String reporterNickname;
    private String reportedNickname;
}


