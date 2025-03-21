package com.tuna.gomen.applicant.service;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import com.tuna.gomen.mapper.ApplicantMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public List<ApplicantDTO> getApplicants(Long teamPostId) {
        return applicantMapper.findApplicantsByPostId(teamPostId);
    }

    @Override
    public List<ApplicantDTO> getMyApplications(Long userId) {
        return applicantMapper.findMyApplications(userId);
    }

//    @Override
//    public List<ApplicantDTO> getMyApplicationsWithStatus(Long userId) {
//        return applicantMapper.findMyApplicationsWithStatus(userId);
//    }

    @Override
    public List<ApplicantDTO> getMyApplicationsWithDetails(Long userId) {
        return applicantMapper.findMyApplicationsWithDetails(userId);
    }
}