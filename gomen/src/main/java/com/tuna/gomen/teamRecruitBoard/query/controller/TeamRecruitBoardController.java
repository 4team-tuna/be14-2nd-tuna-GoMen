package com.tuna.gomen.teamRecruitBoard.query.controller;

import com.tuna.gomen.teamRecruitBoard.query.dto.TeamRecruitWithApplicantsDTO;
import com.tuna.gomen.teamRecruitBoard.command.entity.TeamRecruitBoard;
import com.tuna.gomen.teamRecruitBoard.query.service.TeamRecruitBoardServiceImpl;
import com.tuna.gomen.user.command.entity.User;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/team-recruit")
public class TeamRecruitBoardController {

    @Autowired
    private TeamRecruitBoardServiceImpl teamRecruitBoardService;

    // 팀 모집 게시글 전체 목록 조회
    @GetMapping("/all-recruit-posts")
    public List<TeamRecruitWithApplicantsDTO> getAllRecruitPosts() {
        return teamRecruitBoardService.getAllRecruitPosts();
    }

    // 팀 모집 게시글을 작성한 회원의 닉네임으로 조회
    @GetMapping("/recruit-posts-by-leader/{nickname}")
    public List<TeamRecruitWithApplicantsDTO> getRecruitPostsByLeaderNickname(@PathVariable String nickname) {
        return teamRecruitBoardService.getRecruitPostsByLeaderNickname(nickname);
    }

    // 팀 모집 게시글 제목으로 조회
    @GetMapping("/recruit-posts-by-title/{title}")
    public List<TeamRecruitWithApplicantsDTO> getRecruitPostsByTitle(@PathVariable String title) {
        return teamRecruitBoardService.getRecruitPostsByTitle(title);
    }

    // 팀 모집 게시글 팀명으로 조회
    @GetMapping("/recruit-posts-by-team-name/{teamName}")
    public List<TeamRecruitWithApplicantsDTO> getRecruitPostsByTeamName(@PathVariable String teamName) {
        return teamRecruitBoardService.getRecruitPostsByTeamName(teamName);
    }

    // 팀 모집 게시글 최신순으로 조회
    @GetMapping("/recruit-posts-by-latest")
    public List<TeamRecruitWithApplicantsDTO> getRecentRecruitPosts() {
        return teamRecruitBoardService.getRecentRecruitPosts();
    }

    // 팀 모집 게시글 기간으로 조회
    @GetMapping("/posts-by-date-range/{startDate}/{endDate}")
    public List<TeamRecruitWithApplicantsDTO> getTeamPostsByDateRange(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return teamRecruitBoardService.getTeamPostsByDateRange(startDate, endDate);
    }

    // 모집중인 팀 모집 게시글 조회
    @GetMapping("/active-recruit-posts")
    public List<TeamRecruitWithApplicantsDTO> getActiveRecruitPosts() {
        return teamRecruitBoardService.getActiveRecruitPosts();
    }

}
