package com.tuna.gomen.applicant.controller;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import com.tuna.gomen.applicant.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    // 특정 팀 모집 게시글에 대한 지원자 목록 조회
    @GetMapping("/{teamPostId}")
    public List<ApplicantDTO> getApplicants(@PathVariable Integer teamPostId) {
        return applicantService.getApplicants(teamPostId);
    }

    // 특정 유저가 지원한 모집 게시글 목록 조회
    @GetMapping("/my-applications/{userId}")
    public List<ApplicantDTO> getMyApplications(@PathVariable Integer userId) {
        return applicantService.getMyApplications(userId);
    }

    // 특정 유저가 지원한 모집 게시글 상세 조회
    @GetMapping("/my-applications/details/{userId}")
    public List<ApplicantDTO> getMyApplicationsWithDetails(@PathVariable Integer userId) {
        return applicantService.getMyApplicationsWithDetails(userId);
    }

    // 팀 신청 (POST)
    @PostMapping("/apply")
    public ResponseEntity<String> applyToTeam(
            @RequestParam Integer teamPostId,
            @RequestParam Integer userId,
            @RequestParam String introduce) {
        try {
            applicantService.applyToTeam(teamPostId, userId, introduce);
            return ResponseEntity.ok("팀 신청이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("팀 신청에 실패했습니다: " + e.getMessage());
        }
    }

    // 팀 신청 취소 (DELETE)
    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelApplication(
            @RequestParam Integer teamPostId,
            @RequestParam Integer userId) {
        try {
            applicantService.cancelApplication(teamPostId, userId);
            return ResponseEntity.ok("팀 신청이 취소되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("지원 기록이 존재하지 않습니다: " + e.getMessage());
        }
    }

    // 팀 신청 처리 (PUT) - 수락 여부 (Y 또는 N)
    @PutMapping("/process")
    public ResponseEntity<String> processApplication(
            @RequestParam Integer teamPostId,
            @RequestParam Integer userId,
            @RequestParam String isProcessed) {
        try {
            applicantService.processApplication(teamPostId, userId, isProcessed);
            return ResponseEntity.ok("팀 신청이 처리되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("팀 신청 처리에 실패했습니다: " + e.getMessage());
        }
    }
}
