package com.tuna.gomen.starPointReview.command.controller;

import com.tuna.gomen.starPointReview.command.dto.RatingReviewRequestDto;
import com.tuna.gomen.starPointReview.command.service.RatingReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/review")
@RequiredArgsConstructor
public class RatingReviewCommandController {

    private final RatingReviewService service;

    @PostMapping
    public ResponseEntity<?> writeReview(@RequestBody RatingReviewRequestDto dto) {
        try {
            System.out.println(">> 리뷰 작성 요청 도착: " + dto);
            service.writeReview(dto);
            return ResponseEntity.ok("리뷰가 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();  // 예외 전체 콘솔 출력
            return ResponseEntity.status(500).body("서버 오류: " + e.getMessage());
        }
    }
}

