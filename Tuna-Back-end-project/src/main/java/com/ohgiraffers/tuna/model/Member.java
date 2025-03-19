package com.ohgiraffers.tuna.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("User")
public class Member {
    private Integer userId;
    private String loginId;
    private String password;
    private String name;
    private String personalNumber;
    private String phoneNumber;
    private String nickname;

}
