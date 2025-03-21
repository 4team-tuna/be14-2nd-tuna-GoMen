package com.tuna.gomen.board.query.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String loginId;
    private String name;
    private String phoneNumber;
    private String nickname;
    private String careerInfo;
    private LocalDateTime createdAt;
}
