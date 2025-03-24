package com.tuna.gomen.applicant.entity;

import com.tuna.gomen.teamRecruitBoard.entity.TeamRecruitBoard;
import com.tuna.gomen.user.command.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_applicant")
@IdClass(ApplicantId.class)
@Getter
@Setter
public class Applicant {

    @Id
    @Column(name = "team_post_id")
    private Long teamPostId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "team_post_id", insertable = false, updatable = false)
    private TeamRecruitBoard teamRecruitBoard;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "introduce", nullable = false, length = 500)
    private String introduce;

    @Column(name = "is_processed", nullable = false)
    private Boolean isProcessed;
}
