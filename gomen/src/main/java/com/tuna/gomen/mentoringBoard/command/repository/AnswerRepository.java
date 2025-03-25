package com.tuna.gomen.mentoringBoard.command.repository;

import com.tuna.gomen.mentoringBoard.command.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
