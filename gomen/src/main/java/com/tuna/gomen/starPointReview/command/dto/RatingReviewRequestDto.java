package com.tuna.gomen.starPointReview.command.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingReviewRequestDto {
    private int star;
    private String review;
    private int mentorId;
    private int menteeId;
    private int mentoringSpaceId;
}