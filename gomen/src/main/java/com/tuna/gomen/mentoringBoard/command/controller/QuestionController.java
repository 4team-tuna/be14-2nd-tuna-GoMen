package com.tuna.gomen.mentoringBoard.command.controller;

import com.tuna.gomen.mentoringBoard.command.dto.QuestionRequest;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionResponse;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionUpdateRequest;
import com.tuna.gomen.mentoringBoard.command.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/gomen/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // 멘토링 질문 등록
    // localhost:8080/gomen/questions/create/5
    @PostMapping(value = "/create/{userId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<QuestionResponse> createQuestion(@PathVariable Integer userId,
                                                           @RequestPart("request") QuestionRequest request,
                                                           @RequestPart(value = "files", required = false) List<MultipartFile> files) {

        if(files != null) {  // 파일이 있을 경우만 DTO에 설정
            request.setFiles(files);
        }

        return ResponseEntity.ok(questionService.createQuestion(userId,request));
    }

    // 멘토링 질문 수정
    // localhost:8080/gomen/questions/update/11
    @PatchMapping("/update/{questionId}")
    public ResponseEntity<QuestionResponse> updateQuestion(@PathVariable Integer questionId,
                                                           @RequestBody QuestionUpdateRequest request) {

        return ResponseEntity.ok(questionService.updateQuestion(questionId,request));
    }

    // 멘토링 질문 삭제
    // localhost:8080/gomen/questions/delete/11
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<QuestionResponse> deleteQuestion(@PathVariable Integer questionId) {
        return ResponseEntity.ok(questionService.deleteQuestion(questionId));
    }


}
