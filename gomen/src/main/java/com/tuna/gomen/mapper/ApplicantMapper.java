package com.tuna.gomen.mapper;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplicantMapper {

    // 특정 팀 모집 게시글에 지원한 지원자 목록 조회
    List<ApplicantDTO> findApplicantsByPostId(@Param("teamPostId") Long teamPostId);

    // 특정 유저가 지원한 모집 게시글 목록 조회
    List<ApplicantDTO> findMyApplications(@Param("userId") Long userId);

//    // 특정 유저가 지원한 모집 게시글에서 수락 여부 확인
//    List<ApplicantDTO> findMyApplicationsWithStatus(@Param("userId") Long userId);

    // 특정 유저가 지원한 모집 게시글 상세 조회
    List<ApplicantDTO> findMyApplicationsWithDetails(@Param("userId") Long userId);
}
