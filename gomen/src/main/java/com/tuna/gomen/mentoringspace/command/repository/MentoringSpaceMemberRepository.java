package com.tuna.gomen.mentoringspace.command.repository;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringSpaceMemberRepository extends JpaRepository<MentoringSpaceMember, Integer> {
}
