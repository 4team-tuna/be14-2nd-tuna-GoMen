package com.tuna.gomen.starPointReview.command.controller;

import com.tuna.gomen.starPointReview.command.dto.RatingReviewRequestDTO;
import com.tuna.gomen.starPointReview.command.service.RatingReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/review")
public class RatingReviewCommandController {

    private final RatingReviewService ratingReviewService;

    @Autowired
    public RatingReviewCommandController(RatingReviewService ratingReviewService) {
        this.ratingReviewService = ratingReviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRatingAndReview(@RequestBody RatingReviewRequestDTO dto) {
        String result = ratingReviewService.createRatingAndReview(dto);
        return ResponseEntity.ok(result);
    }

}

