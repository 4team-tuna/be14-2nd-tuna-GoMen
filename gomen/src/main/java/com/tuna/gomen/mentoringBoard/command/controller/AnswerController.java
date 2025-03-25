package com.tuna.gomen.mentoringBoard.command.controller;

import com.tuna.gomen.mentoringBoard.command.dto.AnswerRequest;
import com.tuna.gomen.mentoringBoard.command.dto.AnswerResponse;
import com.tuna.gomen.mentoringBoard.command.dto.QuestionRequest;
import com.tuna.gomen.mentoringBoard.command.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/gomen/answers")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    // 답변 등록, 재답변 등록
    // localhost:8080/gomen/answers/create/1
    // localhost:8080/gomen/answers/create/5
    @PostMapping(value = "/create/{userId}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AnswerResponse> createAnswer(@PathVariable Integer userId,
                                                       @RequestPart("request") AnswerRequest request,
                                                       @RequestPart(value = "files", required = false)
                                                           List<MultipartFile> files) {
        if(files != null) {  // 파일이 있을 경우만 DTO에 설정
            request.setFiles(files);
        }

        return ResponseEntity.ok(answerService.createAnswer(userId,request));
    }

    // 답변 수정
    // localhost:8080/gomen/answers/update/6/1
    @PatchMapping("/update/{answerId}/{userId}")
    public ResponseEntity<AnswerResponse> updateAnswer(@PathVariable Integer answerId,
                                                       @PathVariable Integer userId,
                                                       @RequestPart("request") AnswerRequest request,
                                                       @RequestPart(value = "files", required = false)
                                                           List<MultipartFile> files) {

        if(files != null) {  // 파일이 있을 경우만 DTO에 설정
            request.setFiles(files);
        }

        return ResponseEntity.ok(answerService.updateAnswer(answerId,userId,request));
    }

    // 답변 삭제
    // localhost:8080/gomen/answers/delete/6/1
    @DeleteMapping("/delete/{answerId}/{userId}")
    public ResponseEntity<AnswerResponse> deleteAnswer(@PathVariable Integer answerId,
                                                       @PathVariable Integer userId) {
        return ResponseEntity.ok(answerService.deleteAnswer(answerId,userId));
    }
}
