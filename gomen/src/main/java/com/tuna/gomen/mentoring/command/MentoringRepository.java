package com.tuna.gomen.mentoring.command;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoringRepository extends JpaRepository<Mentoring, MentoringRequestPK> {
}
