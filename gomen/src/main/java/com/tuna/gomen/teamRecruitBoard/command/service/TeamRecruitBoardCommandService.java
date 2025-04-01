package com.tuna.gomen.teamRecruitBoard.command.service;

import com.tuna.gomen.teamRecruitBoard.command.entity.TeamRecruitBoard;

public interface TeamRecruitBoardCommandService {
    TeamRecruitBoard createTeamRecruit(TeamRecruitBoard teamRecruitBoard);
    void deleteTeamRecruit(Integer teamPostId, Integer leaderId);

}
