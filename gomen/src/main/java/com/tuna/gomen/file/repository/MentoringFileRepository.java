package com.tuna.gomen.file.repository;

import com.tuna.gomen.file.entity.MentoringFile;
import com.tuna.gomen.mentoringBoard.command.entity.Answer;
import com.tuna.gomen.mentoringBoard.command.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentoringFileRepository extends JpaRepository<MentoringFile, Long> {
    List<MentoringFile> findByQuestionId(Question question);
    List<MentoringFile> findByAnswerId(Answer answer);
    void deleteAllByQuestionId(Question question);
    void deleteAllByAnswerId(Answer answer);
}
