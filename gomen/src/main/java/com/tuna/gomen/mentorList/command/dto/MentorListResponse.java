package com.tuna.gomen.mentorList.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MentorListResponse {
    private Integer mentorId;
    private String expert;
    private String content;
    private String isDeleted;
}
