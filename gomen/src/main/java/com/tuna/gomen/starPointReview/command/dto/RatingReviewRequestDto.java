package com.tuna.gomen.starPointReview.command.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingReviewRequestDto {
    private int star;
    private String review;
    private int reviewerId;     // 리뷰 작성자
    private int targetUserId;   // 리뷰 대상
    private int mentoringSpaceId;
}