package com.tuna.gomen.applicant.query.service;

import com.tuna.gomen.applicant.query.dto.ApplicantDTO;
import com.tuna.gomen.mapper.ApplicantMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApplicantServiceImplTest {

    @InjectMocks
    private ApplicantServiceImpl applicantService;

    @Mock
    private ApplicantMapper applicantMapper;

    private Integer teamPostId;
    private Integer userId;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        teamPostId = 1;
        userId = 1;
    }

    @Test
    public void 팀_신청_리스트_조회_정상_동작_테스트() {
        // 준비
        ApplicantDTO mockApplicant = new ApplicantDTO();
        when(applicantMapper.findApplicantsByPostId(teamPostId)).thenReturn(List.of(mockApplicant));

        // 실행
        List<ApplicantDTO> applicants = applicantService.getApplicants(teamPostId);

        // 검증
        assertNotNull(applicants);
        assertEquals(1, applicants.size());
        verify(applicantMapper, times(1)).findApplicantsByPostId(teamPostId);
    }

    @Test
    public void 내_팀_신청_리스트_조회_정상_동작_테스트() {
        // 준비
        ApplicantDTO mockApplicant = new ApplicantDTO();
        when(applicantMapper.findMyApplications(userId)).thenReturn(List.of(mockApplicant));

        // 실행
        List<ApplicantDTO> applicants = applicantService.getMyApplications(userId);

        // 검증
        assertNotNull(applicants);
        assertEquals(1, applicants.size());
        verify(applicantMapper, times(1)).findMyApplications(userId);
    }

    @Test
    public void 내_팀_신청_상세_리스트_조회_정상_동작_테스트() {
        // 준비
        ApplicantDTO mockApplicant = new ApplicantDTO();
        when(applicantMapper.findMyApplicationsWithDetails(userId)).thenReturn(List.of(mockApplicant));

        // 실행
        List<ApplicantDTO> applicants = applicantService.getMyApplicationsWithDetails(userId);

        // 검증
        assertNotNull(applicants);
        assertEquals(1, applicants.size());
        verify(applicantMapper, times(1)).findMyApplicationsWithDetails(userId);
    }
}
