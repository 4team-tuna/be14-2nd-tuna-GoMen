package com.tuna.gomen.applicant.repository;

import com.tuna.gomen.applicant.entity.Applicant;
import com.tuna.gomen.applicant.entity.ApplicantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, ApplicantId> {
    boolean existsByTeamPostIdAndUserId(Integer teamPostId, Integer userId);
}