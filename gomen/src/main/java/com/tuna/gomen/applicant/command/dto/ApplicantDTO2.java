package com.tuna.gomen.applicant.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDTO2 {
    private Integer userId;
    private String nickname;
    private String introduce;
    private String isProcessed;
    private Integer teamPostId;
    private String postTitle;
    private String teamName;
}
