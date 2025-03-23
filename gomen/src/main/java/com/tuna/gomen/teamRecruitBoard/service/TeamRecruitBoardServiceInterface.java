package com.tuna.gomen.teamRecruitBoard.service;

import com.tuna.gomen.teamRecruitBoard.entity.TeamRecruitBoard;

public interface TeamRecruitBoardServiceInterface {
    TeamRecruitBoard createTeamRecruit(TeamRecruitBoard teamRecruitBoard);
    void deleteTeamRecruit(Integer teamPostId, Integer leaderId);
}
