package com.tuna.gomen.applicant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDTO {
    private Long userId;
    private String nickname;
    private String introduce;
    private String isProcessed;
    private Long teamPostId;
    private String postTitle;
    private String teamName;
}
