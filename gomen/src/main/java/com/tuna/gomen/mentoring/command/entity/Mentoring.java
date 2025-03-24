package com.tuna.gomen.mentoring.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_mentoring")
@IdClass(MentoringRequestPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Mentoring {

    @Id
    @Column(name = "mentor_id")
    private Integer mentorId;

    @Id
    @Column(name = "mentee_id")
    private Integer menteeId;

    @Id
    @Column(name = "team_id")
    private Integer teamId; // 0 이면 개인 멘토링

    @Column(name = "is_accepted", nullable = false)
    private String isAccepted;
}
