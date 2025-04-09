package com.tuna.gomen.starPointReview.command.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class RatingAndReviewId implements Serializable {
    private Integer mentorId;
    private Integer menteeId;
    private Integer mentoringSpaceId;

    public RatingAndReviewId() {
    }

    public RatingAndReviewId(Integer mentorId, Integer menteeId, Integer mentoringSpaceId) {
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.mentoringSpaceId = mentoringSpaceId;
    }
}