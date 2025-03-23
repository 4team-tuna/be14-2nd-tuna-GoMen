package com.tuna.gomen.mentoringBoard.command.controller;

import com.tuna.gomen.mentoringBoard.command.dto.QuestionCreateRequest;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionCreateResponse;
import com.tuna.gomen.mentoringBoard.command.enriry.Question;
import com.tuna.gomen.mentoringBoard.command.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gomen/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // 멘토링 질문 등록
    // localhost:8080/gomen/questions/create/5
    @PostMapping("/create/{userId}")
    public ResponseEntity<QuestionCreateResponse> register(@PathVariable Integer userId,
                                                           @RequestBody QuestionCreateRequest request) {

        return ResponseEntity.ok(questionService.createQuestion(userId,request));
    }


}
