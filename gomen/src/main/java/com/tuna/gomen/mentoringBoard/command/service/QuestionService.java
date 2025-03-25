package com.tuna.gomen.mentoringBoard.command.service;

import com.tuna.gomen.file.Service.FileStorageService;
import com.tuna.gomen.file.entity.MentoringFile;
import com.tuna.gomen.file.repository.MentoringFileRepository;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionRequest;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionResponse;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionUpdateRequest;
import com.tuna.gomen.mentoringBoard.command.entity.Question;
import com.tuna.gomen.mentoringBoard.command.repository.QuestionRepository;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceMemberRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final MentoringSpaceRepository mentoringSpaceRepository;
    private final MentoringSpaceMemberRepository mentoringSpaceMemberRepository;
    private final FileStorageService fileStorageService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository,
                           UserRepository userRepository,
                           MentoringSpaceRepository mentoringSpaceRepository,
                           MentoringSpaceMemberRepository mentoringSpaceMemberRepository, FileStorageService fileStorageService) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.mentoringSpaceRepository = mentoringSpaceRepository;
        this.mentoringSpaceMemberRepository = mentoringSpaceMemberRepository;
        this.fileStorageService = fileStorageService;
    }

    @Transactional
    public QuestionResponse createQuestion(Integer userId, QuestionRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        MentoringSpace space = mentoringSpaceRepository.findById(request.getMentoringSpaceId())
                .orElseThrow(() -> new IllegalArgumentException("멘토링 공간 없음"));

        MentoringSpaceMember member = mentoringSpaceMemberRepository
                .findByMentoringSpaceIdAndUserId(space, user)
                .orElseThrow(() -> new IllegalArgumentException("멘토링 공간 멤버가 아닙니다."));

        int leftover = member.getLeftoverQuestion();
        if (leftover <= 0) {
            throw new IllegalStateException("남은 질문 횟수가 없습니다.");
        }
        member.setLeftoverQuestion(leftover - 1);

        Question question = new Question();
        question.setQuestionContent(request.getQuestionContent());
        question.setQuestionCreatedTime(LocalDateTime.now());
        question.setMemberId(user);
        question.setMentoringSpaceId(space);

        if (request.getFiles() != null && !request.getFiles().isEmpty()) {
            if (space.getExtensionCount() == 0) {
                throw new IllegalStateException("멘토링 공간의 extensionCount가 0이므로 파일 업로드 불가");
            }

            for (MultipartFile file : request.getFiles()) {
                String originalFileName = file.getOriginalFilename();
                String storedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
                String filePath = fileStorageService.storeFile(file, storedFileName);

                MentoringFile mentoringFile = new MentoringFile();
                mentoringFile.setOriginalFileName(originalFileName);
                mentoringFile.setStoredFileName(storedFileName);
                mentoringFile.setFilePath(filePath);
                mentoringFile.setQuestionId(question);

                question.getFiles().add(mentoringFile);
            }
        }

        Question saved = questionRepository.save(question);

        List<String> filePaths = saved.getFiles().stream()
                .map(MentoringFile::getFilePath)
                .collect(Collectors.toList());

        return new QuestionResponse(
                saved.getQuestionId(),
                saved.getQuestionContent(),
                saved.getQuestionCreatedTime(),
                saved.getMemberId().getUserId(),
                saved.getMentoringSpaceId().getMentoringSpaceId(),
                saved.getIsDeleted(),
                filePaths
        );
    }

    @Transactional
    public QuestionResponse updateQuestion(Integer questionId, QuestionUpdateRequest request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("질문이 존재하지 않습니다."));

        question.setQuestionContent(request.getQuestionContent());

        Question updated = questionRepository.save(question);

        return new QuestionResponse(
                updated.getQuestionId(),
                updated.getQuestionContent(),
                updated.getQuestionCreatedTime(),
                updated.getMemberId().getUserId(),
                updated.getMentoringSpaceId().getMentoringSpaceId(),
                updated.getIsDeleted(),
                Collections.emptyList()
        );

    }

    public QuestionResponse deleteQuestion(Integer questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 질문이 존재하지 않습니다."));

        question.setIsDeleted("Y");
        Question deleted = questionRepository.save(question);

        return new QuestionResponse(
                deleted.getQuestionId(),
                deleted.getQuestionContent(),
                deleted.getQuestionCreatedTime(),
                deleted.getMemberId().getUserId(),
                deleted.getMentoringSpaceId().getMentoringSpaceId(),
                deleted.getIsDeleted(),
                Collections.emptyList()
        );
    }
}
