////package com.tuna.gomen.applicant.service;
////
////import com.tuna.gomen.applicant.command.entity.Applicant;
////import com.tuna.gomen.applicant.command.entity.ApplicantId;
////import com.tuna.gomen.applicant.command.repository.ApplicantRepository;
////import com.tuna.gomen.applicant.query.service.ApplicantServiceImpl;
////import com.tuna.gomen.mapper.ApplicantMapper;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.concurrent.Callable;
////import java.util.concurrent.ExecutorService;
////import java.util.concurrent.Executors;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.MockitoAnnotations;
////
////import java.util.Optional;
////
////import static org.junit.jupiter.api.Assertions.*;
////import static org.mockito.Mockito.*;
////
////public class ApplicantServiceImplTest {
////
////    @InjectMocks
////    private ApplicantServiceImpl applicantService;
////
////    @Mock
////    private ApplicantRepository applicantRepository;
////
////    @Mock
////    private ApplicantMapper applicantMapper;
////
////    private Integer teamPostId;
////    private Integer userId;
////
////    @BeforeEach
////    public void setUp() {
////        MockitoAnnotations.openMocks(this);
////        teamPostId = 1;
////        userId = 1;
////    }
////
////    @Test
////    public void 팀_신청시_DB_저장_정상_작동_테스트() {
////        // 준비
////        when(applicantRepository.existsByTeamPostIdAndUserId(teamPostId, userId)).thenReturn(false);
////
////        // 실행
////        applicantService.applyToTeam(teamPostId, userId, "소개글");
////
////        // 검증
////        verify(applicantRepository, times(1)).save(any(Applicant.class));
////    }
////
////    @Test
////    public void 이미_지원한_팀에_지원한_경우에_대한_예외처리_테스트() {
////        // 준비
////        when(applicantRepository.existsByTeamPostIdAndUserId(teamPostId, userId)).thenReturn(true);
////
////        // 실행 & 검증
////        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
////            applicantService.applyToTeam(teamPostId, userId, "소개글");
////        });
////        assertEquals("이미 지원한 팀입니다.", exception.getMessage());
////    }
////
////    @Test
////    public void 팀_지원_요청_철회_테스트() {
////        // 준비
////        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
////        when(applicantRepository.existsById(applicantId)).thenReturn(true);
////
////        // 실행
////        applicantService.cancelApplication(teamPostId, userId);
////
////        // 검증
////        verify(applicantRepository, times(1)).deleteById(applicantId);
////    }
////
////    @Test
////    public void 지원기록이_존재하지_않는_지원_삭제_요청_처리_테스트() {
////        // 준비
////        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
////        when(applicantRepository.existsById(applicantId)).thenReturn(false);
////
////        // 실행 & 검증
////        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
////            applicantService.cancelApplication(teamPostId, userId);
////        });
////        assertEquals("지원 기록이 존재하지 않습니다.", exception.getMessage());
////    }
////
////    @Test
////    public void 지원_처리_정상_동작_테스트() {
////        // 준비
////        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
////        Applicant applicant = new Applicant();
////        applicant.setIsProcessed(null);  // 아직 처리되지 않은 상태
////        when(applicantRepository.findById(applicantId)).thenReturn(Optional.of(applicant));
////
////        // 실행
////        applicantService.processApplication(teamPostId, userId, "Y");
////
////        // 검증
////        assertEquals("Y", applicant.getIsProcessed());
////        verify(applicantRepository, times(1)).save(applicant);
////    }
////
////    @Test
////    public void 처리된_신청에_대한_처리시도_테스트() {
////        // 준비
////        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
////        Applicant applicant = new Applicant();
////        applicant.setIsProcessed("Y");  // 이미 처리된 상태
////        when(applicantRepository.findById(applicantId)).thenReturn(Optional.of(applicant));
////
////        // 실행 & 검증
////        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
////            applicantService.processApplication(teamPostId, userId, "N");
////        });
////        assertEquals("이미 처리된 신청입니다. 상태를 변경할 수 없습니다.", exception.getMessage());
////    }
////
////    @Test
////    public void Y_또는_N이_아닌_처리_시도시_발생하는_오류_테스트() {
////        // 실행 & 검증
////        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
////            applicantService.processApplication(teamPostId, userId, "A");
////        });
////        assertEquals("잘못된 처리 상태입니다. (Y 또는 N만 허용)", exception.getMessage());
////    }
////
////    @Test
////    public void 서버_부하_테스트() {
////        // 여러 요청을 동시에 처리할 때 성능 저하나 오류가 발생하지 않는지 테스트
////        ExecutorService executor = Executors.newFixedThreadPool(10);  // 10개의 스레드를 사용
////        List<Callable<Void>> tasks = new ArrayList<>();
////
////        for (int i = 0; i < 100; i++) {  // 100번의 요청을 보내는 시나리오
////            tasks.add(() -> {
////                try {
////                    applicantService.processApplication(teamPostId, userId, "Y");
////                } catch (Exception e) {
////                    e.printStackTrace(); // 오류가 발생할 경우 로그에 기록
////                }
////                return null;
////            });
////        }
////
////        try {
////            executor.invokeAll(tasks);  // 요청을 동시에 실행
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////    }
////
////}
