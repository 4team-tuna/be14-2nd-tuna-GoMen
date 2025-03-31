package com.tuna.gomen.starPointReview.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "StarPointReviewMentoring")
@Table(name = "tbl_mentoring")
@IdClass(MentoringId.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mentoring {

    @Id
    @Column(name = "mentor_id")
    private Integer mentorId;

    @Id
    @Column(name = "mentee_id")
    private Integer menteeId;

    @Id
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "is_accepted")
    private String isAccepted;
}
