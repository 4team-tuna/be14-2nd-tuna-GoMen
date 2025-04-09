package com.tuna.gomen.starPointReview.command.entity;

import com.tuna.gomen.mentorList.command.entity.MentorList;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_rating_and_review")
@IdClass(RatingAndReviewId.class)
@Getter
@Setter
public class RatingAndReview {

    @Id
    @Column(name = "mentor_id")
    private Integer mentorId;

    @Id
    @Column(name = "mentee_id")
    private Integer menteeId;

    @Id
    @Column(name = "mentoring_space_id")
    private Integer mentoringSpaceId;

    @ManyToOne
    @JoinColumn(name = "mentor_id", insertable = false, updatable = false)
    private MentorList mentorList;

    @ManyToOne
    @JoinColumn(name = "mentee_id", insertable = false, updatable = false)
    private User mentee;

    @ManyToOne
    @JoinColumn(name = "mentoring_space_id", insertable = false, updatable = false)
    private MentoringSpace mentoringSpace;

    @Column(name = "star")
    private Integer star;

    @Column(name = "review")
    private String review;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
