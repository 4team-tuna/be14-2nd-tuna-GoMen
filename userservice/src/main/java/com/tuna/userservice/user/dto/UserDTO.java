package com.tuna.userservice.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String loginId;
    private String password;
    private String name;
    private String personalNumber;
    private String phoneNumber;
    private String nickname;
    private java.util.Date createdAt;
    private java.util.Date updatedAt;
    private java.util.Date willBeActivated;
    private String isQuitted;
    private String githubAdress;
    private Integer extensionCount;
    private String careerInfo;
    private String isMentor;
    private Integer violationScore;
}
