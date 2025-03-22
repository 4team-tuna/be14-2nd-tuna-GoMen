package com.tuna.gomen.mentoringspace.command.controller;

import com.tuna.gomen.mentoringspace.command.service.MentoringSpaceService;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gomen/mentoringspace")
public class MentoringSpaceController {

    private final MentoringSpaceService mentoringSpaceService;

    @Autowired
    public MentoringSpaceController(MentoringSpaceService mentoringSpaceService) {
        this.mentoringSpaceService = mentoringSpaceService;
    }

    @PostMapping("/create")
    public ResponseEntity<MentoringSpace> createMentoringSpace(@RequestBody MentoringSpace request) {
        MentoringSpace result = mentoringSpaceService.createMentoringSpace(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/update/{mentoringSpaceId}")
    public ResponseEntity<MentoringSpace> updateMentoringSpace(@PathVariable Integer mentoringSpaceId,
                                                               @RequestBody MentoringSpace request) {
        MentoringSpace updated = mentoringSpaceService.updateMentoringSpace(mentoringSpaceId,request);
        return ResponseEntity.ok(updated);
    }


}
