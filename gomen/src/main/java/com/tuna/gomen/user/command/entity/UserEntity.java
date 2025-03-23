package com.tuna.gomen.user.command.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class UserEntity {

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

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private java.util.Date createdAt;

    @Column(nullable = true)
    private java.util.Date updatedAt;

    @Column(nullable = false)
    private java.util.Date willBeActivated;

    @Column(nullable = false)
    private String isQuitted;

    @Column(nullable = true)
    private String githubAdress;

    @Column(nullable = false)
    private Integer extensionCount;

    @Column(nullable = true)
    private String careerInfo;

    @Column(nullable = false)
    private String isMentor;

    @Column(nullable = false)
    private Integer violationScore;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.willBeActivated = new Date();
        this.isQuitted = "N";
        this.extensionCount = 0;
        this.isMentor = "N";
        this.violationScore = 0;
    }
}