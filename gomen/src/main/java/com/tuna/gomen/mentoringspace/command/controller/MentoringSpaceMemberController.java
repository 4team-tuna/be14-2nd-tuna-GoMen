package com.tuna.gomen.mentoringspace.command.controller;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.service.MentoringSpaceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gomen/mentoringspace/member")
public class MentoringSpaceMemberController {

    private final MentoringSpaceMemberService memberService;

    @Autowired
    public MentoringSpaceMemberController(MentoringSpaceMemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public ResponseEntity<MentoringSpaceMember> register(@RequestParam Integer mentoringSpaceId,
                                                         @RequestParam Integer userId) {
        MentoringSpaceMember registered = memberService.registerMember(mentoringSpaceId, userId);
        return ResponseEntity.ok(registered);
    }
}
