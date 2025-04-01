package com.tuna.gomen.mapper;

import com.tuna.gomen.teamRecruitBoard.query.dto.TeamRecruitWithApplicantsDTO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamRecruitBoardMapper {

    List<TeamRecruitWithApplicantsDTO> findAllRecruitPosts();

    List<TeamRecruitWithApplicantsDTO> findRecruitPostsByLeaderNickname(String nickname);

    List<TeamRecruitWithApplicantsDTO> findRecruitPostsByTitle(String title);

    List<TeamRecruitWithApplicantsDTO> findRecruitPostsByTeamName(String teamName);

    List<TeamRecruitWithApplicantsDTO> findRecentRecruitPosts();

    List<TeamRecruitWithApplicantsDTO> findTeamRecruitPostsByDateRange(LocalDate startDate, LocalDate endDate);

    List<TeamRecruitWithApplicantsDTO> findActiveRecruitPosts();

}

