package com.tuna.gomen.starPointReview.command.service;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.starPointReview.command.dto.RatingReviewRequestDTO;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReview;
import com.tuna.gomen.starPointReview.command.entity.RatingAndReviewId;
import com.tuna.gomen.starPointReview.command.repository.RatingAndReviewRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.mentorList.command.repository.MentorListRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RatingReviewService {

    private final RatingAndReviewRepository ratingAndReviewRepository;
    private final MentoringSpaceRepository metoringSpaceRepository;
    private final MentorListRepository mentorListRepository;
    private final UserRepository userRepository;

    public RatingReviewService(RatingAndReviewRepository ratingRepository, MentoringSpaceRepository spaceRepository,
                               MentorListRepository mentorListRepository, UserRepository userRepository) {
        this.ratingAndReviewRepository = ratingRepository;
        this.metoringSpaceRepository = spaceRepository;
        this.mentorListRepository = mentorListRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public String createRatingAndReview(RatingReviewRequestDTO dto) {
        // 멘토링 공간 활성화 여부 체크
        Optional<MentoringSpace> mentoringSpaceOpt = metoringSpaceRepository.findById(dto.getMentoringSpaceId());
        if (mentoringSpaceOpt.isEmpty()) return "존재하지 않는 멘토링 공간입니다.";

        MentoringSpace mentoringSpace = mentoringSpaceOpt.get();
        if (!"N".equals(mentoringSpace.getIsActivated())) return "멘토링이 종료되지 않았습니다.";

        // 중복 확인
        RatingAndReviewId id = new RatingAndReviewId(dto.getTargetUserId(), dto.getReviewerId(), dto.getMentoringSpaceId());
        if (ratingAndReviewRepository.existsById(id)) return "이미 리뷰를 작성하셨습니다.";

        // 리뷰 저장
        RatingAndReview rating = new RatingAndReview();
        rating.setMentorId(dto.getTargetUserId());
        rating.setMenteeId(dto.getReviewerId());
        rating.setMentoringSpaceId(dto.getMentoringSpaceId());
        rating.setStar(dto.getStar());
        rating.setReview(dto.getReview());
        rating.setCreatedAt(LocalDateTime.now());

        ratingAndReviewRepository.save(rating);

        // 평균 별점 계산 및 유저 테이블 업데이트
        Double averageRating = ratingAndReviewRepository.findAverageStarByMentorId(dto.getTargetUserId());
        Optional<User> mentorUserOpt = userRepository.findById(dto.getTargetUserId());
        mentorUserOpt.ifPresent(user -> {
            user.setAverageRating(averageRating);
            userRepository.save(user);
        });

        return "리뷰 등록이 완료되었습니다.";
    }

}
