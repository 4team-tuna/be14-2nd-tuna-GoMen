package com.tuna.gomen.mentorList.command.controller;

import com.tuna.gomen.mentorList.command.dto.MentorListRequest;
import com.tuna.gomen.mentorList.command.dto.MentorListResponse;
import com.tuna.gomen.mentorList.command.service.MentorListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/mentorlist")
public class MentorListCommandController {

    private final MentorListService mentorListService;

    @Autowired
    public MentorListCommandController(MentorListService mentorListService) {
        this.mentorListService = mentorListService;
    }

    @PostMapping("/add")
    public ResponseEntity<MentorListResponse> addMentor(@RequestBody MentorListRequest request) {
        return ResponseEntity.ok(mentorListService.addMentor(request));
    }

    @DeleteMapping("/remove/{mentorId}")
    public ResponseEntity<Void> removeMentor(@PathVariable Integer mentorId) {
        mentorListService.removeMentor(mentorId);
        return ResponseEntity.noContent().build();
    }
}
