package com.tuna.gomen.starPointReview.command.repository;

import com.tuna.gomen.starPointReview.command.entity.RatingAndReview;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingAndReviewRepository extends JpaRepository<RatingAndReview, RatingAndReviewId> {
}