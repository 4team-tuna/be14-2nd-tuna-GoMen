package com.tuna.gomen.mapper;

import com.tuna.gomen.teamRecruitBoard.dto.TeamRecruitWithApplicantsDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamRecruitBoardMapper {

    List<TeamRecruitWithApplicantsDTO> findTeamRecruitWithApplicants(Long teamPostId);

    List<TeamRecruitWithApplicantsDTO> findMyApplications(Long userId);

    List<TeamRecruitWithApplicantsDTO> findAllTeamRecruitPosts();

    TeamRecruitWithApplicantsDTO findTeamRecruitPostDetails(Long teamPostId);

//    List<TeamRecruitWithApplicantsDTO> findMyApplicationsWithStatus(Long userId);

    List<TeamRecruitWithApplicantsDTO> findCompletedPosts();

    List<TeamRecruitWithApplicantsDTO> findActivePosts();

    List<TeamRecruitWithApplicantsDTO> findMyApplicationsWithDetails(Long userId);
}

