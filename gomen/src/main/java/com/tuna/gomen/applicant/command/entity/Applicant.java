package com.tuna.gomen.applicant.command.entity;

import com.tuna.gomen.teamRecruitBoard.command.entity.TeamRecruitBoard;
import com.tuna.gomen.user.command.entity.User;
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
    private Integer teamPostId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "team_post_id", insertable = false, updatable = false)
    private TeamRecruitBoard teamRecruitBoard;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "introduce", nullable = false)
    private String introduce;

    @Column(name = "is_processed")
    private String isProcessed;
}
