package com.tuna.gomen.board.query.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserEntity {
    private Long userId;
    private String loginId;
    private String name;
    private String phoneNumber;
    private String nickname;
    private String careerInfo;
    private LocalDateTime createdAt;
}
