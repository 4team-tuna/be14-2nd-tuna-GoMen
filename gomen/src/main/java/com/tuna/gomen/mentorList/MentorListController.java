package com.tuna.gomen.mentorList;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gomen")
@Slf4j
public class MentorListController {

    private final MentorListService mentorListService;

    @Autowired
    public MentorListController(MentorListService mentorListService) {
        this.mentorListService = mentorListService;
    }

    @GetMapping("/mentorlist")
    public List<MentorListDTO> getMentors() {
        return mentorListService.findAllActiveMentors();
    }
}

