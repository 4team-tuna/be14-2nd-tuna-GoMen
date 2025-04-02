package com.tuna.gomen.teamRecruitBoard.command.controller;

import com.tuna.gomen.teamRecruitBoard.command.entity.TeamRecruitBoard;
import com.tuna.gomen.teamRecruitBoard.command.service.TeamRecruitBoardCommandServiceImpl;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/team-recruit")
public class TeamRecruitBoardCommandController {

    @Autowired
    private TeamRecruitBoardCommandServiceImpl teamRecruitBoardCommandServiceImpl;

    @Autowired
    private UserRepository userRepository;

    //    http://localhost:8080/gomen/team-recruit/create
    @PostMapping("/create")
    public ResponseEntity<String> createTeamRecruit(
            @RequestParam String postTitle,
            @RequestParam String teamName,
            @RequestParam String teamIntroduce,
            @RequestParam Integer leaderId) {  // leaderId를 요청에서 받음

        // User 엔티티를 leaderId로 조회
        User leader = userRepository.findById(leaderId)
                .orElseThrow(() -> new RuntimeException("리더를 찾을 수 없습니다."));

        // TeamRecruitBoard 엔티티 생성 및 값 설정
        TeamRecruitBoard teamRecruitBoard = new TeamRecruitBoard();
        teamRecruitBoard.setPostTitle(postTitle);
        teamRecruitBoard.setTeamName(teamName);
        teamRecruitBoard.setTeamIntroduce(teamIntroduce);
        teamRecruitBoard.setLeader(leader);

        // 서비스에서 게시글 생성 처리
        teamRecruitBoardCommandServiceImpl.createTeamRecruit(teamRecruitBoard);

        // 생성 성공 메시지 반환
        return ResponseEntity.ok("팀 모집 글이 성공적으로 생성되었습니다.");
    }


    // 팀 모집 게시글 삭제 (리더만 가능)
//    http://localhost:8080/gomen/team-recruit/delete/31?leaderId=1
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeamRecruit(
            @RequestParam Integer teamPostId,
            @RequestParam Integer leaderId) {  // 요청에서 leaderId 받기

        // 서비스에서 삭제 진행
        teamRecruitBoardCommandServiceImpl.deleteTeamRecruit(teamPostId, leaderId);  // serviceImpl 사용

        // 삭제 성공 메시지 반환
        return ResponseEntity.ok("팀 모집 글이 삭제되었습니다.");
    }
}
