package com.tuna.gomen.starPointReview.command.service;

import com.tuna.gomen.starPointReview.command.dto.RatingReviewRequestDto;
import com.tuna.gomen.starPointReview.command.entity.MentoringSpace;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReview;
import com.tuna.gomen.starPointReview.command.repository.MentoringRepository2;
import com.tuna.gomen.starPointReview.command.repository.MentoringSpaceRepository2;
import com.tuna.gomen.starPointReview.command.repository.RatingAndReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RatingReviewService {

    private final RatingAndReviewRepository ratingRepo;
    private final MentoringSpaceRepository2 spaceRepo;
    private final MentoringRepository2 mentoringRepo;

    @Transactional
    public void writeReview(RatingReviewRequestDto dto) {
        MentoringSpace space = spaceRepo.findById(dto.getMentoringSpaceId())
                .orElseThrow(() -> new IllegalArgumentException("멘토링 스페이스를 찾을 수 없습니다."));

        if (!"N".equals(space.getIsActivated())) {
            throw new IllegalStateException("멘토링이 종료되어야 리뷰 작성이 가능합니다.");
        }

        boolean isMentored = mentoringRepo
                .findByMentorIdAndMenteeIdAndTeamIdAndIsAccepted(dto.getMentorId(), dto.getMenteeId(), 0,"Y")
                .isPresent();

        if (!isMentored) {
            throw new IllegalStateException("멘토링 관계가 형성되지 않았습니다.");
        }

        ratingRepo.save(RatingAndReview.builder()
                .star(dto.getStar())
                .review(dto.getReview())
                .mentorId(dto.getMentorId())
                .menteeId(dto.getMenteeId())
                .mentoringSpaceId(dto.getMentoringSpaceId())
                .build());
    }
}