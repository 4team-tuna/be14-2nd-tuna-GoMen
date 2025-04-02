package com.tuna.gomen.applicant.command.controller;

import com.tuna.gomen.applicant.command.dto.ApplicantDTO2;
import com.tuna.gomen.applicant.command.service.ApplicantCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gomen/applicants")
public class ApplicantCommandController {

    @Autowired
    private ApplicantCommandService applicantCommandService;

    // 팀 신청 (POST)
    @PostMapping("/apply")
    public ResponseEntity<String> applyToTeam(@RequestBody ApplicantDTO2 applicantDTO2) {
        try {
            applicantCommandService.applyToTeam(applicantDTO2.getTeamPostId()
                    , applicantDTO2.getUserId(), applicantDTO2.getIntroduce());
            return ResponseEntity.ok("팀 신청이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("팀 신청에 실패했습니다: " + e.getMessage());
        }
    }


    // 팀 신청 취소 (DELETE)
    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelApplication(@RequestBody ApplicantDTO2 applicantDTO2) {
        try {
            applicantCommandService.cancelApplication(applicantDTO2.getTeamPostId(), applicantDTO2.getUserId());
            return ResponseEntity.ok("팀 신청이 취소되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("지원 기록이 존재하지 않습니다: " + e.getMessage());
        }
    }

    // 팀 신청 처리 (PUT) - 수락 여부 (Y 또는 N)
    @PutMapping("/process")
    public ResponseEntity<String> processApplication(@RequestBody ApplicantDTO2 applicantDTO2) {
        try {
            applicantCommandService.processApplication(applicantDTO2.getTeamPostId(), applicantDTO2.getUserId(), applicantDTO2.getIsProcessed());
            return ResponseEntity.ok("팀 신청이 처리되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("팀 신청 처리에 실패했습니다: " + e.getMessage());
        }
    }
}
