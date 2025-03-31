package com.tuna.gomen.teamRecruitBoard.query.service;

import com.tuna.gomen.mapper.TeamRecruitBoardMapper;
import com.tuna.gomen.teamRecruitBoard.query.dto.TeamRecruitWithApplicantsDTO;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamRecruitBoardServiceImpl implements TeamRecruitBoardService {

    @Autowired
    private TeamRecruitBoardMapper teamRecruitBoardMapper;

    // 팀 모집 게시글 전체 목록 조회
    public List<TeamRecruitWithApplicantsDTO> getAllRecruitPosts() {
        return teamRecruitBoardMapper.findAllRecruitPosts();
    }

    // 팀 모집 게시글을 작성한 회원의 닉네임으로 조회
    public List<TeamRecruitWithApplicantsDTO> getRecruitPostsByLeaderNickname(String nickname) {
        return teamRecruitBoardMapper.findRecruitPostsByLeaderNickname(nickname);
    }

    // 팀 모집 게시글 제목으로 조회
    public List<TeamRecruitWithApplicantsDTO> getRecruitPostsByTitle(String title) {
        return teamRecruitBoardMapper.findRecruitPostsByTitle(title);
    }

    // 팀 모집 게시글 팀명으로 조회
    public List<TeamRecruitWithApplicantsDTO> getRecruitPostsByTeamName(String teamName) {
        return teamRecruitBoardMapper.findRecruitPostsByTeamName(teamName);
    }

    // 팀 모집 게시글 최신순으로 조회
    public List<TeamRecruitWithApplicantsDTO> getRecentRecruitPosts() {
        return teamRecruitBoardMapper.findRecentRecruitPosts();
    }

    // 팀 모집 게시글 기간으로 조회
    public List<TeamRecruitWithApplicantsDTO> getTeamPostsByDateRange(LocalDate startDate, LocalDate endDate) {
        return teamRecruitBoardMapper.findTeamRecruitPostsByDateRange(startDate, endDate);
    }


    // 모집중인 팀 모집 게시글 조회
    public List<TeamRecruitWithApplicantsDTO> getActiveRecruitPosts() {
        return teamRecruitBoardMapper.findActiveRecruitPosts();
    }

}
