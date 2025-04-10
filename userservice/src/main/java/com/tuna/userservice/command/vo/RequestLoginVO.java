package com.tuna.userservice.command.vo;

import lombok.Data;

@Data
public class RequestLoginVO {
    private String loginId;
    private String password;
}