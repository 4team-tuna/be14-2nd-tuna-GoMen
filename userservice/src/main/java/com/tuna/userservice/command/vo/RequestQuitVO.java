package com.tuna.userservice.command.vo;

import lombok.Data;

@Data
public class RequestQuitVO {
    private String loginId;
    private String password;
}
