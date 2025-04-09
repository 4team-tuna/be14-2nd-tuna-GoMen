package com.tuna.gomen.starPointReview.command.dto;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingReviewRequestDTO {
    private Integer star;
    private String review;
    private Integer reviewerId;     // 리뷰 작성자(멘티)
    private Integer targetUserId;   // 리뷰 대상(멘토)
    private Integer mentoringSpaceId;
    private LocalDateTime createdAt;

    private Float averageRating;
}