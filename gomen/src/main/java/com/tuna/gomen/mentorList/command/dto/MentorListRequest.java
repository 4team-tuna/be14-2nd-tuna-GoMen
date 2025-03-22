package com.tuna.gomen.mentorList.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorListRequest {
    private Integer mentorId;
    private String mexpert;
    private String mcontent;
}
