package com.tuna.gomen.mentorList.query.controller;

import com.tuna.gomen.mentorList.query.dto.MentorListDTO;
import com.tuna.gomen.mentorList.query.service.MentorListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gomen/mentorlist")
@Slf4j
public class MentorListController {

    private final MentorListService mentorListService;

    @Autowired
    public MentorListController(MentorListService mentorListService) {
        this.mentorListService = mentorListService;
    }

    // 멘토 리스트 조회
    @GetMapping
    public List<MentorListDTO> getMentors() {
        return mentorListService.findAllActiveMentors();
    }
}

