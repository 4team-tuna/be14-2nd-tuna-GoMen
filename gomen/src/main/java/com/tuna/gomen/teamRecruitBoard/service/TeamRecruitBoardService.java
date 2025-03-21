package com.tuna.gomen.teamRecruitBoard.service;

import com.tuna.gomen.mapper.TeamRecruitBoardMapper;
import com.tuna.gomen.teamRecruitBoard.dto.TeamRecruitWithApplicantsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamRecruitBoardService {

    @Autowired
    private TeamRecruitBoardMapper teamRecruitBoardMapper;

//    // 팀 모집 게시글과 지원자 목록 조회
//    public List<TeamRecruitWithApplicantsDTO> getTeamRecruitWithApplicants(Long teamPostId) {
//        return teamRecruitBoardMapper.findTeamRecruitWithApplicants(teamPostId);
//    }

    // 내가 지원한 팀 모집 게시글 조회
    public List<TeamRecruitWithApplicantsDTO> getMyApplications(Long userId) {
        return teamRecruitBoardMapper.findMyApplications(userId);
    }

    // 팀 모집 게시글 전체 목록 조회 (삭제되지 않은 게시글만)
    public List<TeamRecruitWithApplicantsDTO> getAllActiveTeamPosts() {
        return teamRecruitBoardMapper.findAllTeamRecruitPosts();
    }

    // 팀 모집 게시글 상세 조회
    public TeamRecruitWithApplicantsDTO getTeamRecruitDetails(Long teamPostId) {
        return teamRecruitBoardMapper.findTeamRecruitPostDetails(teamPostId);
    }

//    // 내가 지원한 팀 목록에서 수락 여부만 확인
//    public List<TeamRecruitWithApplicantsDTO> getMyApplicationsWithStatus(Long userId) {
//        return teamRecruitBoardMapper.findMyApplicationsWithStatus(userId);
//    }

    // 완료된 팀 모집 게시글 목록 조회
    public List<TeamRecruitWithApplicantsDTO> getCompletedTeamPosts() {
        return teamRecruitBoardMapper.findCompletedPosts();
    }

    // 활성 상태의 팀 모집 게시글 목록 조회
    public List<TeamRecruitWithApplicantsDTO> getActiveTeamPosts() {
        return teamRecruitBoardMapper.findActivePosts();
    }

    // 내가 지원한 팀 모집 게시글 수락여부와 함께 조회
    public List<TeamRecruitWithApplicantsDTO> getMyApplicationsWithDetails(Long userId) {
        return teamRecruitBoardMapper.findMyApplicationsWithDetails(userId);
    }
}
