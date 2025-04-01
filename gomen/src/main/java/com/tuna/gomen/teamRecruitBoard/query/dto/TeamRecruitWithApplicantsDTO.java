package com.tuna.gomen.teamRecruitBoard.query.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRecruitWithApplicantsDTO {

    private Integer teamPostId;
    private String postTitle;
    private String teamName;
    private String teamIntroduce;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String isCompleted;
    private String isDeleted;

    private String leaderNickname;
}
