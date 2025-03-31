package com.tuna.gomen.starPointReview.command.repository;

import com.tuna.gomen.starPointReview.command.entity.Mentoring;
import com.tuna.gomen.starPointReview.command.entity.MentoringId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentoringRepository2 extends JpaRepository<Mentoring, MentoringId> {
    Optional<Mentoring> findByMentorIdAndMenteeIdAndTeamIdAndIsAccepted(
            Integer mentorId,
            Integer menteeId,
            Integer teamId,
            String isAccepted
    );
}
