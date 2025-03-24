package com.tuna.userservice.user.vo;

import lombok.Data;

@Data
public class RequestLoginVO {
    private String loginId;
    private String password;
}