package com.tuna.gomen.starPointReview.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "StarPointReviewMentoringSpace")
@Table(name = "tbl_mentoring_space")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentoringSpace {

    @Id
    @Column(name = "mentoring_space_id")
    private Integer mentoringSpaceId;

    @Column(name = "is_activated")
    private String isActivated;
}
