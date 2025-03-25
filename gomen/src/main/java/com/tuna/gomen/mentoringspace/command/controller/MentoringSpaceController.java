package com.tuna.gomen.mentoringspace.command.controller;

import com.tuna.gomen.mentoringspace.command.dto.PersonalInformationUpdateRequest;
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

    // 멘토링 공간 생성
    // localhost:8080/gomen/mentoringspace/create
    @PostMapping("/create")
    public ResponseEntity<MentoringSpace> createMentoringSpace(@RequestBody MentoringSpace request) {
        MentoringSpace result = mentoringSpaceService.createMentoringSpace(request);
        return ResponseEntity.ok(result);
    }

    // 멘토링 공간 수정
    // localhost:8080/gomen/mentoringspace/update/31
    @PatchMapping("/update/{mentoringSpaceId}")
    public ResponseEntity<MentoringSpace> updateMentoringSpace(@PathVariable Integer mentoringSpaceId,
                                                               @RequestBody MentoringSpace request) {
        MentoringSpace updated = mentoringSpaceService.updateMentoringSpace(mentoringSpaceId,request);
        return ResponseEntity.ok(updated);
    }

    // 멘토링 연락처 등록,수정
    // localhost:8080/gomen/mentoringspace/update/31/personal-info
    @PatchMapping("/update/{mentoringSpaceId}/personal-info")
    public ResponseEntity<MentoringSpace> updatePersonalInformation(
                                                                @PathVariable Integer mentoringSpaceId,
                                                                @RequestBody PersonalInformationUpdateRequest request) {
        MentoringSpace updated = mentoringSpaceService.updatePersonalInformation(
                mentoringSpaceId,
                request.getPersonalInformation()
        );
        return ResponseEntity.ok(updated);
    }

    // 개인정보 공개 요청
    // localhost:8080/gomen/mentoringspace/request-personal-info/31
    @PatchMapping("/request-personal-info/{spaceId}")
    public ResponseEntity<String> requestPersonalInfo(@PathVariable Integer spaceId) {
        mentoringSpaceService.requestPersonalInfo(spaceId);
        return ResponseEntity.ok("개인정보 공개 요청이 완료되었습니다.");
    }

    // 멘토 개인정보 공개 요청 수락
    // localhost:8080/gomen/mentoringspace/approve-personal-info-request/31
    @PatchMapping("/approve-personal-info-request/{mentoringSpaceId}")
    public ResponseEntity<String> approvePersonalInfoRequest(@PathVariable Integer mentoringSpaceId) {
        mentoringSpaceService.approvePersonalInfoRequest(mentoringSpaceId);
        return ResponseEntity.ok("개인정보 공개 요청이 승인되었습니다.");
    }

    // 멘토링 공간 비활성화
    // localhost:8080/gomen/mentoringspace/deactivate/31
    @PatchMapping("/deactivate/{mentoringSpaceId}")
    public ResponseEntity<Void> deactivateMentoringSpace(@PathVariable Integer mentoringSpaceId) {
        mentoringSpaceService.deactivateMentoringSpace(mentoringSpaceId);
        return ResponseEntity.noContent().build();
    }

    // 멘토링 연장 요청
    // localhost:8080/gomen/mentoringspace/extension-request/31?userId=11
    @PostMapping("/extension-request/{spaceId}")
    public ResponseEntity<String> requestExtension(@PathVariable Integer spaceId,
                                                   @RequestParam Integer userId) {
        mentoringSpaceService.requestExtension(spaceId, userId);
        return ResponseEntity.ok("연장 요청이 완료되었습니다.");
    }

    // 멘토링 연장 요청 수락
    // localhost:8080/gomen/mentoringspace/extension-request/approve/31
    @PatchMapping("/extension-request/approve/{spaceId}")
    public ResponseEntity<String> approveExtension(@PathVariable Integer spaceId) {
        mentoringSpaceService.approveExtension(spaceId);
        return ResponseEntity.ok("연장 요청이 수락되었습니다.");
    }

    // 멘토링 연장 요청 거절
    // localhost:8080/gomen/mentoringspace/extension-request/reject/31
    @PatchMapping("/extension-request/reject/{spaceId}")
    public ResponseEntity<String> rejectExtension(@PathVariable Integer spaceId) {
        mentoringSpaceService.rejectExtension(spaceId);
        return ResponseEntity.ok("연장 요청이 거절되어 멘토링 공간이 비활성화되었습니다.");
    }

}
