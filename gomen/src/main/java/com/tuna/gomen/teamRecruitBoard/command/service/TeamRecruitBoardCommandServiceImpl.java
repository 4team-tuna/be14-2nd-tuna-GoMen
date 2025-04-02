package com.tuna.gomen.teamRecruitBoard.command.service;

import com.tuna.gomen.teamRecruitBoard.command.entity.TeamRecruitBoard;
import com.tuna.gomen.teamRecruitBoard.command.repository.TeamRecruitBoardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamRecruitBoardCommandServiceImpl implements TeamRecruitBoardCommandService {

    private final TeamRecruitBoardRepository teamRecruitBoardRepository;

    public TeamRecruitBoardCommandServiceImpl(TeamRecruitBoardRepository teamRecruitBoardRepository) {
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

        // 소프트 딜리트 처리: isDeleted 값을 'Y'로 변경
        post.setIsDeleted("Y");  // 'Y'로 설정하여 삭제된 상태로 표시

        // 게시글 수정 (isDeleted 컬럼만 업데이트)
        teamRecruitBoardRepository.save(post);  // 업데이트된 상태 저장
    }
}
