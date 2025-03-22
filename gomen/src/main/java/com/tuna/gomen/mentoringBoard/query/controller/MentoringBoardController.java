package com.tuna.gomen.mentoringBoard.query.controller;

import com.tuna.gomen.mentoringBoard.query.dto.MentoringBoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gomen/mentoringboard")
@Slf4j
public class MentoringBoardController {

    private final com.tuna.gomen.mentoringBoard.query.service.MentoringBoardService MentoringBoardService;

    @Autowired
    public MentoringBoardController(com.tuna.gomen.mentoringBoard.query.service.MentoringBoardService mentoringBoardService) {
        MentoringBoardService = mentoringBoardService;
    }

    @GetMapping("/leftquestion")
    public List<MentoringBoardDTO> selectLeftOverQuestion(@RequestParam Integer userId) {
        return MentoringBoardService.selectLeftOverQuestion(userId);
    }


}
