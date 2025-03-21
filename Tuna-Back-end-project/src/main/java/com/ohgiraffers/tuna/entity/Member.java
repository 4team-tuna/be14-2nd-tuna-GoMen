package com.ohgiraffers.tuna.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private Integer userId;
    private String loginId;
    private String password;
    private String name;
    private String personalNumber;
    private String phoneNumber;
    private String nickname;
}

