package com.tuna.gomen.applicant.query.service;

import com.tuna.gomen.applicant.query.dto.ApplicantDTO;
import java.util.List;

public interface ApplicantService {

    List<ApplicantDTO> getApplicants(Integer teamPostId);
    List<ApplicantDTO> getMyApplications(Integer userId);
    List<ApplicantDTO> getMyApplicationsWithDetails(Integer userId);
}
