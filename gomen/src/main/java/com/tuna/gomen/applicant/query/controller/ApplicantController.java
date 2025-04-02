package com.tuna.gomen.applicant.query.controller;

import com.tuna.gomen.applicant.query.dto.ApplicantDTO;
import com.tuna.gomen.applicant.query.service.ApplicantService;
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
}
