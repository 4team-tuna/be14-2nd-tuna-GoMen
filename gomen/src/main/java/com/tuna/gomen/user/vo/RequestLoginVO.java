package com.tuna.gomen.user.vo;

import lombok.Data;

@Data
public class RequestLoginVO {
    private String loginId;
    private String password;
}