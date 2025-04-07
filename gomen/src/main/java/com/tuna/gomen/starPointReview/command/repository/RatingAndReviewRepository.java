package com.tuna.gomen.starPointReview.command.repository;

import com.tuna.gomen.starPointReview.command.entity.RatingAndReview;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReviewId;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingAndReviewRepository extends JpaRepository<RatingAndReview, RatingAndReviewId> {

    @Query("SELECT AVG(r.star) FROM RatingAndReview r WHERE r.menteeId = :userId OR r.mentorId = :userId")
    Double findAverageRatingByUserId(@Param("userId") int userId);

}