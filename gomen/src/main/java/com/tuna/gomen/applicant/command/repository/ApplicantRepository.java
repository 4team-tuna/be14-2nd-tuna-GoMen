package com.tuna.gomen.applicant.command.repository;

import com.tuna.gomen.applicant.command.entity.Applicant;
import com.tuna.gomen.applicant.command.entity.ApplicantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, ApplicantId> {
    boolean existsByTeamPostIdAndUserId(Integer teamPostId, Integer userId);
}