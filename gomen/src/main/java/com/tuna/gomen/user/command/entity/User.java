package com.tuna.gomen.user.command.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String personalNumber;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private LocalDateTime willBeActivated = LocalDateTime.now();

    @Column(nullable = false, length = 1)
    private String isQuitted = "N";

    @Column
    private String githubAddress;

    @Column(nullable = false)
    private int extensionCount = 0;

    @Column
    private String careerInfo;

    @Column(nullable = false, length = 1)
    private String isMentor = "N";

    @Column(nullable = false)
    private int violationScore = 0;
}
