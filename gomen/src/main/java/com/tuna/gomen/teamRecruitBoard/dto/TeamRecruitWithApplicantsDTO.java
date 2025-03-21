package com.tuna.gomen.teamRecruitBoard.dto;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRecruitWithApplicantsDTO {
    private Long teamPostId;
    private String postTitle;
    private String teamName;
    private String teamIntroduce;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String isDeleted;
    private String isCompleted;
    private String leaderNickname;

    private List<ApplicantDTO> applicants = new ArrayList<>();  // 빈 리스트로 초기화
}
