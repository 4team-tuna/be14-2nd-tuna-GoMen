package com.tuna.gomen.mentoring.command.repository;

import com.tuna.gomen.mentoring.command.entity.Mentoring;
import com.tuna.gomen.mentoring.command.entity.MentoringRequestPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoringRepository extends JpaRepository<Mentoring, MentoringRequestPK> {
}
