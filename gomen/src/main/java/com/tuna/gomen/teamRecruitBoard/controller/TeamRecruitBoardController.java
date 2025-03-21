package com.tuna.gomen.teamRecruitBoard.controller;

import com.tuna.gomen.teamRecruitBoard.dto.TeamRecruitWithApplicantsDTO;
import com.tuna.gomen.teamRecruitBoard.service.TeamRecruitBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/team-recruit")
public class TeamRecruitBoardController {

    @Autowired
    private TeamRecruitBoardService teamRecruitBoardService;

//    // 팀 모집 게시글과 지원자 목록 조회
//    @GetMapping("/{teamPostId}/applicants")
//    public List<TeamRecruitWithApplicantsDTO> getTeamRecruitWithApplicants(@PathVariable Long teamPostId) {
//        return teamRecruitBoardService.getTeamRecruitWithApplicants(teamPostId);
//    }

    // 내가 지원한 팀 모집 게시글 조회
    @GetMapping("/my-applications/{userId}")
    public List<TeamRecruitWithApplicantsDTO> getMyApplications(@PathVariable Long userId) {
        return teamRecruitBoardService.getMyApplications(userId);
    }

    // 팀 모집 게시글 전체 목록 조회 (삭제되지 않은 게시글만)
    @GetMapping("/all-active-posts")
    public List<TeamRecruitWithApplicantsDTO> getAllActiveTeamPosts() {
        return teamRecruitBoardService.getAllActiveTeamPosts();
    }

    // 팀 모집 게시글 상세 조회
    @GetMapping("/details/{teamPostId}")
    public TeamRecruitWithApplicantsDTO getTeamRecruitDetails(@PathVariable Long teamPostId) {
        return teamRecruitBoardService.getTeamRecruitDetails(teamPostId);
    }

//    // 내가 지원한 팀 목록에서 수락 여부만 확인
//    @GetMapping("/my-applications/status/{userId}")
//    public List<TeamRecruitWithApplicantsDTO> getMyApplicationsWithStatus(@PathVariable Long userId) {
//        return teamRecruitBoardService.getMyApplicationsWithStatus(userId);
//    }

    // 완료된 팀 모집 게시글 목록 조회
    @GetMapping("/completed-posts")
    public List<TeamRecruitWithApplicantsDTO> getCompletedTeamPosts() {
        return teamRecruitBoardService.getCompletedTeamPosts();
    }

    // 활성 상태의 팀 모집 게시글 목록 조회
    @GetMapping("/active-posts")
    public List<TeamRecruitWithApplicantsDTO> getActiveTeamPosts() {
        return teamRecruitBoardService.getActiveTeamPosts();
    }

    // 내가 지원한 팀 모집 게시글 수락여부와 함께 조회
    @GetMapping("/my-applications/details/{userId}")
    public List<TeamRecruitWithApplicantsDTO> getMyApplicationsWithDetails(@PathVariable Long userId) {
        return teamRecruitBoardService.getMyApplicationsWithDetails(userId);
    }

}
