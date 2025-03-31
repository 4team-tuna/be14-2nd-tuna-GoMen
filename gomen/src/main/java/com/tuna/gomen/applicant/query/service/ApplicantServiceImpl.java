package com.tuna.gomen.applicant.query.service;

import com.tuna.gomen.applicant.query.dto.ApplicantDTO;
import com.tuna.gomen.mapper.ApplicantMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public List<ApplicantDTO> getApplicants(Integer teamPostId) {
        return applicantMapper.findApplicantsByPostId(teamPostId);
    }

    @Override
    public List<ApplicantDTO> getMyApplications(Integer userId) {
        return applicantMapper.findMyApplications(userId);
    }

    @Override
    public List<ApplicantDTO> getMyApplicationsWithDetails(Integer userId) {
        return applicantMapper.findMyApplicationsWithDetails(userId);
    }


}