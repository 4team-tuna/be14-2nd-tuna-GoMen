package com.tuna.gomen.teamRecruitBoard.command.repository;

import com.tuna.gomen.teamRecruitBoard.command.entity.TeamRecruitBoard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRecruitBoardRepository extends JpaRepository<TeamRecruitBoard, Integer> {

    // 특정 팀 모집글 조회
    Optional<TeamRecruitBoard> findById(Integer teamPostId);

}
