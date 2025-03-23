package com.tuna.gomen.mentoringBoard.command.service;

import com.tuna.gomen.mentoringBoard.command.dto.AnswerRequest;
import com.tuna.gomen.mentoringBoard.command.dto.AnswerResponse;
import com.tuna.gomen.mentoringBoard.command.entity.Answer;
import com.tuna.gomen.mentoringBoard.command.entity.Question;
import com.tuna.gomen.mentoringBoard.command.repository.AnswerRepository;
import com.tuna.gomen.mentoringBoard.command.repository.QuestionRepository;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceMemberRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final MentoringSpaceRepository mentoringSpaceRepository;


    @Autowired
    public AnswerService(AnswerRepository answerRepository,
                         QuestionRepository questionRepository,
                         UserRepository userRepository,
                         MentoringSpaceRepository mentoringSpaceRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.mentoringSpaceRepository = mentoringSpaceRepository;
    }

    @Transactional
    public AnswerResponse createAnswer(Integer userId, AnswerRequest request) {
        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 질문이 존재하지 않습니다."));

        Integer mentoringSpaceId = question.getMentoringSpaceId().getMentoringSpaceId();

        MentoringSpace mentoringSpace = mentoringSpaceRepository.findById(mentoringSpaceId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토링 공간이 존재하지 않습니다."));

        User member = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        boolean isMentor = mentoringSpace.getMentorId().equals(userId);
        boolean isMember = question.getMemberId().getUserId().equals(userId);

        if (!(isMentor || isMember)) {
            throw new IllegalArgumentException("멘토링 공간의 멘토 또는 질문 작성자만 답변할 수 있습니다.");
        }

        Answer answer = new Answer();
        answer.setAnswerContent(request.getAnswerContent());
        answer.setAnswerMemberId(member);
        answer.setQuestionId(question);
        answer.setMentoringSpaceId(question.getMentoringSpaceId());
        answer.setAnswerCreatedTime(LocalDateTime.now());

        if (request.getRefAnswerId() != null) {
            Answer refAnswer = answerRepository.findById(request.getRefAnswerId())
                    .orElseThrow(() -> new IllegalArgumentException("참조 답변이 존재하지 않습니다."));
            answer.setRefAnswerId(refAnswer);
        }

        Answer saved = answerRepository.save(answer);

        return new AnswerResponse(
                saved.getAnswerId(),
                saved.getAnswerContent(),
                saved.getAnswerCreatedTime(),
                saved.getQuestionId().getQuestionId(),
                saved.getAnswerMemberId().getUserId(),
                saved.getMentoringSpaceId().getMentoringSpaceId(),
                saved.getRefAnswerId() != null ? saved.getRefAnswerId().getAnswerId() : null
        );

    }
}
