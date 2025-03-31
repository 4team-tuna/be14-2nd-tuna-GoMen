package com.tuna.gomen.applicant.command.service;

import com.tuna.gomen.applicant.command.entity.Applicant;
import com.tuna.gomen.applicant.command.entity.ApplicantId;
import com.tuna.gomen.applicant.command.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicantCommandServiceImpl implements ApplicantCommandService {

    @Autowired
    private ApplicantRepository applicantRepository;

    // 팀 신청 (POST)
    @Transactional
    @Override
    public void applyToTeam(Integer teamPostId, Integer userId, String introduce) {
        if (applicantRepository.existsByTeamPostIdAndUserId(teamPostId, userId)) {
            throw new IllegalStateException("이미 지원한 팀입니다.");
        }
        Applicant applicant = new Applicant();
        applicant.setTeamPostId(teamPostId);
        applicant.setUserId(userId);
        applicant.setIntroduce(introduce);
        applicant.setIsProcessed(null);  // 처리 여부를 null로 설정
        applicantRepository.save(applicant);
    }

    // 팀 신청 취소 (DELETE)
    @Transactional
    @Override
    public void cancelApplication(Integer teamPostId, Integer userId) {
        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
        if (!applicantRepository.existsById(applicantId)) {
            throw new IllegalStateException("지원 기록이 존재하지 않습니다.");
        }
        applicantRepository.deleteById(applicantId);  // 하드 딜리트
    }

    // 팀 신청 처리 (PUT)
    @Transactional
    @Override
    public void processApplication(Integer teamPostId, Integer userId, String isProcessed) {
        if (!isProcessed.equals("Y") && !isProcessed.equals("N")) {
            throw new IllegalArgumentException("잘못된 처리 상태입니다. (Y 또는 N만 허용)");
        }

        ApplicantId applicantId = new ApplicantId(teamPostId, userId);
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new IllegalStateException("지원 기록을 찾을 수 없습니다."));

        // 이미 처리 상태가 'Y' 또는 'N'이라면 변경할 수 없도록 막음
        if (applicant.getIsProcessed() != null) {
            throw new IllegalStateException("이미 처리된 신청입니다. 상태를 변경할 수 없습니다.");
        }

        // 처리된 상태로 업데이트
        applicant.setIsProcessed(isProcessed);  // Y 또는 N 값으로 설정
        applicantRepository.save(applicant);
    }
}
