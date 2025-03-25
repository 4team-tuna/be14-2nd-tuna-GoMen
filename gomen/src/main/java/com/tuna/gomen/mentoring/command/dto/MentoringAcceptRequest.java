package com.tuna.gomen.mentoring.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoringAcceptRequest {
    private Integer mentorId;
    private Integer menteeId;
    private Integer teamId;
    private String isAccepted;
}
