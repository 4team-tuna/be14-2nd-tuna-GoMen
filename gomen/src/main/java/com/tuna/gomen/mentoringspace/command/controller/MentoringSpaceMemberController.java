package com.tuna.gomen.mentoringspace.command.controller;

import com.tuna.gomen.mentoringspace.command.dto.MentoringSpaceMemberRequest;
import com.tuna.gomen.mentoringspace.command.dto.MentoringSpaceMemberResponse;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.service.MentoringSpaceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/mentoringspace/member")
public class MentoringSpaceMemberController {

    private final MentoringSpaceMemberService memberService;

    @Autowired
    public MentoringSpaceMemberController(MentoringSpaceMemberService memberService) {
        this.memberService = memberService;
    }

    // 멘토링 멤버 등록
    // localhost:8080/gomen/mentoringspace/member/add
    @PostMapping("/add")
    public ResponseEntity<MentoringSpaceMemberResponse> addMember(@RequestBody MentoringSpaceMemberRequest request) {

        MentoringSpaceMember registered = memberService.addMember(
                request.getMentoringSpaceId(),
                request.getUserId()
        );

        MentoringSpaceMemberResponse response = new MentoringSpaceMemberResponse(
                registered.getMentoringSpaceId().getMentoringSpaceId(),
                registered.getUserId().getUserId(),
                registered.getLeftoverQuestion()
        );

        return ResponseEntity.ok(response);
    }
}
