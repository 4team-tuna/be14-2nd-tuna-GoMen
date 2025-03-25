package com.tuna.gomen.mentoringspace.command.repository;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.user.command.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MentoringSpaceMemberRepository extends JpaRepository<MentoringSpaceMember, Integer> {
    boolean existsByMentoringSpaceIdAndUserId(MentoringSpace mentoringSpace, User userId);

    Optional<MentoringSpaceMember> findByMentoringSpaceIdAndUserId(MentoringSpace mentoringSpace, User userId);

    MentoringSpaceMember findByMentoringSpaceId_MentoringSpaceId(Integer mentoringSpaceId);
}
