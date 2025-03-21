package com.tuna.gomen.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int userId;
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
    private int extensionCount;
    private String careerInfo;
    private String isMentor;
    private int violationScore;
}
