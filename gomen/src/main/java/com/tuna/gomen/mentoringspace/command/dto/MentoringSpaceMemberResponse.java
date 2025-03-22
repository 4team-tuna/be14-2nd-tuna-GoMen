package com.tuna.gomen.mentoringspace.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MentoringSpaceMemberResponse {
    private Integer mentoringSpace;
    private Integer mentee;
    private Integer leftoverQuestion;
}
