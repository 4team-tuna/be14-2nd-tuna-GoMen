package com.tuna.gomen.applicant.service;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import java.util.List;

public interface ApplicantService {

    List<ApplicantDTO> getApplicants(Long teamPostId);
    List<ApplicantDTO> getMyApplications(Long userId);
//    List<ApplicantDTO> getMyApplicationsWithStatus(Long userId);
    List<ApplicantDTO> getMyApplicationsWithDetails(Long userId);

}
