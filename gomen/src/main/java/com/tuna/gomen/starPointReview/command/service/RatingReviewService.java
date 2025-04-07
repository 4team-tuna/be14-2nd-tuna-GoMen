package com.tuna.gomen.starPointReview.command.service;

import com.tuna.gomen.starPointReview.command.dto.RatingReviewRequestDto;
import com.tuna.gomen.starPointReview.command.entity.MentoringSpace;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReview;
import com.tuna.gomen.starPointReview.command.repository.MentoringRepository2;
import com.tuna.gomen.starPointReview.command.repository.MentoringSpaceRepository2;
import com.tuna.gomen.starPointReview.command.repository.RatingAndReviewRepository;
import com.tuna.gomen.starPointReview.command.repository.UserRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RatingReviewService {

    private final RatingAndReviewRepository ratingRepo;
    private final MentoringSpaceRepository2 spaceRepo;
    private final MentoringRepository2 mentoringRepo;
    private final UserRepository2 userRepository;

    @Transactional
    public void writeReview(RatingReviewRequestDto dto) {
        MentoringSpace space = spaceRepo.findById(dto.getMentoringSpaceId())
                .orElseThrow(() -> new IllegalArgumentException("멘토링 스페이스를 찾을 수 없습니다."));

        if (!"N".equals(space.getIsActivated())) {
            throw new IllegalStateException("멘토링이 종료되어야 리뷰 작성이 가능합니다.");
        }

        // 멘토링 관계 있는지 확인 (둘 중 누가 멘토든)
        boolean isValidRelation = mentoringRepo
                .findByMentorIdAndMenteeIdAndTeamIdAndIsAccepted(dto.getReviewerId(), dto.getTargetUserId(), 0, "Y")
                .isPresent()
                || mentoringRepo
                .findByMentorIdAndMenteeIdAndTeamIdAndIsAccepted(dto.getTargetUserId(), dto.getReviewerId(), 0, "Y")
                .isPresent();

        if (!isValidRelation) {
            throw new IllegalStateException("멘토링 관계가 형성되지 않았습니다.");
        }

        // 누가 멘토인지 판단
        int mentorId, menteeId;
        if (mentoringRepo.findByMentorIdAndMenteeIdAndTeamIdAndIsAccepted(dto.getReviewerId(), dto.getTargetUserId(), 0, "Y").isPresent()) {
            mentorId = dto.getReviewerId();
            menteeId = dto.getTargetUserId();
        } else {
            mentorId = dto.getTargetUserId();
            menteeId = dto.getReviewerId();
        }

        ratingRepo.save(RatingAndReview.builder()
                .star(dto.getStar())
                .review(dto.getReview())
                .mentorId(mentorId)
                .menteeId(menteeId)
                .mentoringSpaceId(dto.getMentoringSpaceId())
                .build());

        // 평균 별점 갱신 대상은 받은 사람 (targetUserId)
        Double avgRating = ratingRepo.findAverageRatingByUserId(dto.getTargetUserId());
        if (avgRating != null) {
            userRepository.findById(dto.getTargetUserId()).ifPresent(user -> {
                user.setAverageRating(avgRating.floatValue());
                userRepository.save(user);
            });
        }
    }

}