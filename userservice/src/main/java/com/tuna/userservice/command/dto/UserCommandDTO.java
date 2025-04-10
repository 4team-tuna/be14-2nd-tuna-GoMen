package com.tuna.userservice.command.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCommandDTO {
    private Integer userId;
    private String loginId;
    private String password;
    private String name;
    private String personalNumber;
    private String phoneNumber;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime willBeActivated;
    private String isQuitted;
    private String githubAdress;
    private Integer extensionCount;
    private String careerInfo;
    private String isMentor;
    private Integer violationScore;
    private Double averageRating;
    private String college;
    private String blog;
}
