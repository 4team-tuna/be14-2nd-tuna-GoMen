package com.tuna.gomen.mentoringBoard.command.service;

import com.tuna.gomen.mentoringBoard.command.dto.QuestionCreateRequest;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionCreateResponse;
import com.tuna.gomen.mentoringBoard.command.enriry.Question;
import com.tuna.gomen.mentoringBoard.command.repository.QuestionRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final MentoringSpaceRepository mentoringSpaceRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository,
                           UserRepository userRepository,
                           MentoringSpaceRepository mentoringSpaceRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.mentoringSpaceRepository = mentoringSpaceRepository;
    }

    @Transactional
    public QuestionCreateResponse createQuestion(Integer userId, QuestionCreateRequest request) {
        Question question = new Question();
        question.setQuestionContent(request.getQuestionContent());
        question.setQuestionCreatedTime(LocalDateTime.now());
        question.setMemberId(userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음")));

        // 멘토링 공간 설정 필요하면 여기서 추가
        question.setMentoringSpaceId(mentoringSpaceRepository.findById(request.getMentoringSpaceId())
                .orElseThrow(() -> new IllegalArgumentException("멘토링 공간 없음")));

        Question saved = questionRepository.save(question);

        return new QuestionCreateResponse(
                saved.getQuestionId(),
                saved.getQuestionContent(),
                saved.getQuestionCreatedTime(),
                saved.getMemberId().getUserId(),
                saved.getMentoringSpaceId().getMentoringSpaceId()
        );
    }
}
