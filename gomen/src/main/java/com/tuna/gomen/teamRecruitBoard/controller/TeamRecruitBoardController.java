package com.tuna.gomen.teamRecruitBoard.controller;

import com.tuna.gomen.user.command.entity.UserEntity;
import com.tuna.gomen.user.repository.UserRepository;
import com.tuna.gomen.teamRecruitBoard.dto.TeamRecruitWithApplicantsDTO;
import com.tuna.gomen.teamRecruitBoard.entity.TeamRecruitBoard;
import com.tuna.gomen.teamRecruitBoard.service.TeamRecruitBoardService;
import com.tuna.gomen.teamRecruitBoard.service.TeamRecruitBoardServiceImpl;
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
    private TeamRecruitBoardService teamRecruitBoardService;

    @Autowired
    private TeamRecruitBoardServiceImpl teamRecruitBoardServiceImpl;
    @Autowired
    private UserRepository userRepository;

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

//    http://localhost:8080/gomen/team-recruit/create
    @PostMapping("/create")
    public ResponseEntity<String> createTeamRecruit(
            @RequestParam String postTitle,
            @RequestParam String teamName,
            @RequestParam String teamIntroduce,
            @RequestParam Integer leaderId) {  // leaderId를 요청에서 받음

        // User 엔티티를 leaderId로 조회
        UserEntity leader = userRepository.findById(leaderId)
                .orElseThrow(() -> new RuntimeException("리더를 찾을 수 없습니다."));

        // TeamRecruitBoard 엔티티 생성 및 값 설정
        TeamRecruitBoard teamRecruitBoard = new TeamRecruitBoard();
        teamRecruitBoard.setPostTitle(postTitle);
        teamRecruitBoard.setTeamName(teamName);
        teamRecruitBoard.setTeamIntroduce(teamIntroduce);
        teamRecruitBoard.setLeader(leader);

        // 서비스에서 게시글 생성 처리
        teamRecruitBoardServiceImpl.createTeamRecruit(teamRecruitBoard);

        // 생성 성공 메시지 반환
        return ResponseEntity.ok("팀 모집 글이 성공적으로 생성되었습니다.");
    }


    // 팀 모집 게시글 삭제 (리더만 가능)
//    http://localhost:8080/gomen/team-recruit/delete/31?leaderId=1
    @DeleteMapping("/delete/{teamPostId}")
    public ResponseEntity<String> deleteTeamRecruit(
            @PathVariable Integer teamPostId,
            @RequestParam Integer leaderId) {  // 요청에서 leaderId 받기

        // 서비스에서 삭제 진행
        teamRecruitBoardServiceImpl.deleteTeamRecruit(teamPostId, leaderId);  // serviceImpl 사용

        // 삭제 성공 메시지 반환
        return ResponseEntity.ok("팀 모집 글이 삭제되었습니다.");
    }

}
