package com.tuna.gomen.mentoring.command.controller;

import com.tuna.gomen.mentoring.command.dto.MentoringAcceptRequest;
import com.tuna.gomen.mentoring.command.dto.MentoringRequest;
import com.tuna.gomen.mentoring.command.service.MentoringService;
import com.tuna.gomen.mentoring.command.entity.Mentoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gomen/mentoring")
public class MentoringController {

    private final MentoringService mentoringService;

    @Autowired
    public MentoringController(MentoringService mentoringService) {
        this.mentoringService = mentoringService;
    }

    // 멘토링 신청( 멘토가 있어야 함)
    // localhost:8080/gomen/mentoring/apply
    @PostMapping("/apply")
    public ResponseEntity<Mentoring> applyMentoring(@RequestBody MentoringRequest request) {
        Mentoring apply = mentoringService.applyMentoring(request);
        return ResponseEntity.ok(apply);
    }

    @PatchMapping("/accept")
    public ResponseEntity<Mentoring> acceptMentoring(@RequestBody MentoringAcceptRequest request) {
        Mentoring accept = mentoringService.acceptMentoring(request);
        return ResponseEntity.ok(accept);
    }

}
