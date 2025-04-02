package com.tuna.gomen.starPointReview.command.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingAndReviewId implements Serializable {
    private int mentorId;
    private int menteeId;
    private int mentoringSpaceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingAndReviewId that = (RatingAndReviewId) o;
        return mentorId == that.mentorId &&
                menteeId == that.menteeId &&
                mentoringSpaceId == that.mentoringSpaceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorId, menteeId, mentoringSpaceId);
    }
}