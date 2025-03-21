package com.tuna.gomen.applicant.controller;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import com.tuna.gomen.applicant.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    // 특정 팀 모집 게시글에 대한 지원자 목록 조회
    @GetMapping("/{teamPostId}")
    public List<ApplicantDTO> getApplicants(@PathVariable Long teamPostId) {
        return applicantService.getApplicants(teamPostId);
    }

    // 특정 유저가 지원한 모집 게시글 목록 조회
    @GetMapping("/my-applications/{userId}")
    public List<ApplicantDTO> getMyApplications(@PathVariable Long userId) {
        return applicantService.getMyApplications(userId);
    }

//    // 특정 유저가 지원한 모집 게시글에서 수락 여부 확인
//    @GetMapping("/my-applications/status/{userId}")
//    public List<ApplicantDTO> getMyApplicationsWithStatus(@PathVariable Long userId) {
//        return applicantService.getMyApplicationsWithStatus(userId);
//    }

    // 특정 유저가 지원한 모집 게시글 상세 조회
    @GetMapping("/my-applications/details/{userId}")
    public List<ApplicantDTO> getMyApplicationsWithDetails(@PathVariable Long userId) {
        return applicantService.getMyApplicationsWithDetails(userId);
    }
}
