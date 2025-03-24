package com.tuna.gomen.mentoringspace.command.repository;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentoringSpaceRepository extends JpaRepository<MentoringSpace, Integer> {
    Optional<MentoringSpace> findByMentoringSpaceId(Integer mentoringSpaceId);
}
