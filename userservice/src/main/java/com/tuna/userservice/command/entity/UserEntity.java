package com.tuna.userservice.command.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDateTime willBeActivated;

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

    @Column(nullable = false)
    private Double averageRating;

    @Column(nullable = true)
    private String college;

    @Column(nullable = true)
    private String blog;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.willBeActivated = LocalDateTime.now();
        this.isQuitted = "N";
        this.extensionCount = 0;
        this.isMentor = "N";
        this.violationScore = 0;
        this.averageRating = 0.0;
    }
}