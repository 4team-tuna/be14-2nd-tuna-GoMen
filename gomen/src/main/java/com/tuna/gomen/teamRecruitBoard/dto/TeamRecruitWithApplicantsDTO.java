package com.tuna.gomen.teamRecruitBoard.dto;

import com.tuna.gomen.applicant.dto.ApplicantDTO;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String isCompleted;
    private String isDeleted;

    private String leaderNickname;
}
