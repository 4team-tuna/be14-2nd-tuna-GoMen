package com.tuna.gomen.mentoringBoard.command.service;

import com.tuna.gomen.mentoringBoard.command.dto.AnswerRequest;
import com.tuna.gomen.mentoringBoard.command.dto.AnswerResponse;
import com.tuna.gomen.mentoringBoard.command.entity.Answer;
import com.tuna.gomen.mentoringBoard.command.entity.Question;
import com.tuna.gomen.mentoringBoard.command.repository.AnswerRepository;
import com.tuna.gomen.mentoringBoard.command.repository.QuestionRepository;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
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
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        Answer answer = new Answer();
        answer.setAnswerContent(request.getAnswerContent());
        answer.setAnswerMemberId(user);
        answer.setAnswerCreatedTime(LocalDateTime.now());

        if (request.getRefAnswerId() != null) {
            // 대댓글 처리 (질문자는 refAnswerId만 가지고 요청)
            Answer refAnswer = answerRepository.findById(request.getRefAnswerId())
                    .orElseThrow(() -> new IllegalArgumentException("참조 답변이 존재하지 않습니다."));

            Question question = refAnswer.getQuestionId();
            MentoringSpace space = refAnswer.getMentoringSpaceId();

            boolean isMember = question.getMemberId().getUserId().equals(userId);

            if (!isMember) {
                throw new IllegalArgumentException("질문자만 대댓글을 작성할 수 있습니다.");
            }

            answer.setQuestionId(question);
            answer.setMentoringSpaceId(space);
            answer.setRefAnswerId(refAnswer);
        } else {
            // 일반 답변 처리 (멘토만 가능)
            Question question = questionRepository.findById(request.getQuestionId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 질문이 존재하지 않습니다."));

            MentoringSpace space = question.getMentoringSpaceId();

            if (!space.getMentorId().equals(userId)) {
                throw new IllegalArgumentException("멘토만 답변을 작성할 수 있습니다.");
            }

            answer.setQuestionId(question);
            answer.setMentoringSpaceId(space);
        }

        Answer saved = answerRepository.save(answer);

        return new AnswerResponse(
                saved.getAnswerId(),
                saved.getAnswerContent(),
                saved.getAnswerCreatedTime(),
                saved.getQuestionId().getQuestionId(),
                saved.getAnswerMemberId().getUserId(),
                saved.getMentoringSpaceId().getMentoringSpaceId(),
                saved.getRefAnswerId() != null ? saved.getRefAnswerId().getAnswerId() : null,
                saved.getIsDeleted()
        );

    }

    @Transactional
    public AnswerResponse updateAnswer(Integer answerId,Integer userId, AnswerRequest request) {

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("답변이 존재하지 않습니다."));

        if (!answer.getAnswerMemberId().getUserId().equals(userId)) {
            throw new IllegalArgumentException("본인이 작성한 답변만 수정할 수 있습니다.");
        }

        if ("Y".equals(answer.getIsDeleted())) {
            throw new IllegalArgumentException("삭제된 답변은 수정할 수 없습니다.");
        }

        answer.setAnswerContent(request.getAnswerContent());

        return new AnswerResponse(
                answer.getAnswerId(),
                answer.getAnswerContent(),
                answer.getAnswerCreatedTime(),
                answer.getQuestionId().getQuestionId(),
                answer.getAnswerMemberId().getUserId(),
                answer.getMentoringSpaceId().getMentoringSpaceId(),
                answer.getRefAnswerId() != null ? answer.getRefAnswerId().getAnswerId() : null,
                answer.getIsDeleted()
        );
    }

    @Transactional
    public AnswerResponse deleteAnswer(Integer answerId, Integer userId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 답변이 존재하지 않습니다."));

        // 작성자 본인만 삭제 가능
        if (!answer.getAnswerMemberId().getUserId().equals(userId)) {
            throw new IllegalArgumentException("답변 작성자만 삭제할 수 있습니다.");
        }

        answer.setIsDeleted("Y");
        answerRepository.save(answer);

        return new AnswerResponse(
                answer.getAnswerId(),
                answer.getAnswerContent(),
                answer.getAnswerCreatedTime(),
                answer.getQuestionId().getQuestionId(),
                answer.getAnswerMemberId().getUserId(),
                answer.getMentoringSpaceId().getMentoringSpaceId(),
                answer.getRefAnswerId() != null ? answer.getRefAnswerId().getAnswerId() : null,
                answer.getIsDeleted()
        );
    }
}
