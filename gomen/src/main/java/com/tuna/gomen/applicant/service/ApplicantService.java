package com.tuna.gomen.applicant.service;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import java.util.List;

public interface ApplicantService {

    List<ApplicantDTO> getApplicants(Integer teamPostId);
    List<ApplicantDTO> getMyApplications(Integer userId);
//    List<ApplicantDTO> getMyApplicationsWithStatus(Long userId);
    List<ApplicantDTO> getMyApplicationsWithDetails(Integer userId);

}
