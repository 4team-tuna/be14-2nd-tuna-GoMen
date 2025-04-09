package com.tuna.gomen.starPointReview.command.repository;

import com.tuna.gomen.starPointReview.command.entity.RatingAndReview;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingAndReviewRepository extends JpaRepository<RatingAndReview, RatingAndReviewId> {

    @Query("SELECT ROUND(AVG(r.star), 1) FROM RatingAndReview r WHERE r.mentorId = :mentorId")
    Double findAverageStarByMentorId(@Param("mentorId") Integer mentorId);

}
