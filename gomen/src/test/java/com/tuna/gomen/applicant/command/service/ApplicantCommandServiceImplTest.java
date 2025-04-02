package com.tuna.gomen.applicant.command.service;

import com.tuna.gomen.applicant.command.entity.Applicant;
import com.tuna.gomen.applicant.command.entity.ApplicantId;
import com.tuna.gomen.applicant.command.repository.ApplicantRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApplicantCommandServiceImplTest {

    @InjectMocks
    private ApplicantCommandServiceImpl applicantCommandService;

    @Mock
    private ApplicantRepository applicantRepository;

    private Integer teamPostId;
    private Integer userId;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        teamPostId = 1;
        userId = 1;
    }

    @Test
    public void 팀_신청시_DB_저장_정상_작동_테스트() {
        // 준비
        when(applicantRepository.existsByTeamPostIdAndUserId(teamPostId, userId)).thenReturn(false);

        // 실행
        applicantCommandService.applyToTeam(teamPostId, userId, "소개글");

        // 검증
        verify(applicantRepository, times(1)).save(any(Applicant.class));
    }

    @Test
    public void 이미_지원한_팀에_지원한_경우에_대한_예외처리_테스트() {
        // 준비
        when(applicantRepository.existsByTeamPostIdAndUserId(teamPostId, userId)).thenReturn(true);

        // 실행 & 검증
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            applicantCommandService.applyToTeam(teamPostId, userId, "소개글");
        });
        assertEquals("이미 지원한 팀입니다.", exception.getMessage());
    }

    @Test
    public void 팀_지원_요청_철회_테스트() {
        // 준비
        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
        when(applicantRepository.existsById(applicantId)).thenReturn(true);

        // 실행
        applicantCommandService.cancelApplication(teamPostId, userId);

        // 검증
        verify(applicantRepository, times(1)).deleteById(applicantId);
    }

    @Test
    public void 지원기록이_존재하지_않는_지원_삭제_요청_처리_테스트() {
        // 준비
        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
        when(applicantRepository.existsById(applicantId)).thenReturn(false);

        // 실행 & 검증
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            applicantCommandService.cancelApplication(teamPostId, userId);
        });
        assertEquals("지원 기록이 존재하지 않습니다.", exception.getMessage());
    }

    @Test
    public void 지원_처리_정상_동작_테스트() {
        // 준비
        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
        Applicant applicant = new Applicant();
        applicant.setIsProcessed(null);  // 아직 처리되지 않은 상태
        when(applicantRepository.findById(applicantId)).thenReturn(Optional.of(applicant));

        // 실행
        applicantCommandService.processApplication(teamPostId, userId, "Y");

        // 검증
        assertEquals("Y", applicant.getIsProcessed());
        verify(applicantRepository, times(1)).save(applicant);
    }
}
