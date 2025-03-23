package com.tuna.gomen.teamRecruitBoard.service;

import com.tuna.gomen.teamRecruitBoard.entity.TeamRecruitBoard;
import com.tuna.gomen.teamRecruitBoard.repository.TeamRecruitBoardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.access.AccessDeniedException;

@Service
public class TeamRecruitBoardServiceImpl implements TeamRecruitBoardServiceInterface {

    private final TeamRecruitBoardRepository teamRecruitBoardRepository;

    public TeamRecruitBoardServiceImpl(TeamRecruitBoardRepository teamRecruitBoardRepository) {
        this.teamRecruitBoardRepository = teamRecruitBoardRepository;
    }

    // 팀 모집 글 생성
    @Transactional
    @Override
    public TeamRecruitBoard createTeamRecruit(TeamRecruitBoard teamRecruitBoard) {
        return teamRecruitBoardRepository.save(teamRecruitBoard);
    }

    // 팀 모집 게시글 삭제 (리더만 가능)
    @Transactional
    @Override
    public void deleteTeamRecruit(Integer teamPostId, Integer leaderId) {
        // 팀 모집 글 조회 (없으면 예외 발생)
        TeamRecruitBoard post = teamRecruitBoardRepository.findById(teamPostId)
                .orElseThrow(() -> new EntityNotFoundException("팀 모집 글이 존재하지 않습니다."));

        // 작성자가 리더인지 확인
        if (post.getLeader() == null || !post.getLeader().getUserId().equals(leaderId)) {
            throw new IllegalStateException("삭제 권한이 없습니다.");
        }

        // 삭제 진행
        teamRecruitBoardRepository.delete(post);
    }
}
