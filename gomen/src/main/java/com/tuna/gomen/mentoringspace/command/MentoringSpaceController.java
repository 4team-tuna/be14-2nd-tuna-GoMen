package com.tuna.gomen.mentoringspace.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gomen/mentoringspace")
public class MentoringSpaceController {

    private final MentoringSpaceService mentoringSpaceService;

    @Autowired
    public MentoringSpaceController(MentoringSpaceService mentoringSpaceService) {
        this.mentoringSpaceService = mentoringSpaceService;
    }

//    @PostMapping("/")
}
