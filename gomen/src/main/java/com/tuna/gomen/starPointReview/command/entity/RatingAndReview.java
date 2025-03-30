// 패키지: com.tuna.gomen.starPointReview.command.entity

package com.tuna.gomen.starPointReview.command.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_rating_and_review")
@IdClass(RatingAndReviewId.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RatingAndReview {

    @Id
    @Column(name = "mentor_id")
    private int mentorId;

    @Id
    @Column(name = "mentee_id")
    private int menteeId;

    @Id
    @Column(name = "mentoring_space_id")
    private int mentoringSpaceId;

    private int star;

    private String review;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
