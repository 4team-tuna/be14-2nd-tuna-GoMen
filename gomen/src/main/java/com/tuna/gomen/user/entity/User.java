package com.tuna.gomen.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String isMentor;
    private String isQuitted;
    private Integer violationScore = 0;
}
