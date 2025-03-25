package com.tuna.gomen.mentoringspace.command.repository;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.user.command.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentoringSpaceMemberRepository extends JpaRepository<MentoringSpaceMember, Integer> {
    boolean existsByMentoringSpaceIdAndUserId(MentoringSpace mentoringSpace, UserEntity userId);

    Optional<MentoringSpaceMember> findByMentoringSpaceIdAndUserId(MentoringSpace mentoringSpace, UserEntity userId);
}
