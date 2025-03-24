package com.tuna.gomen.mentoringspace.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoringSpaceMemberRequest {
    private Integer mentoringSpaceId;
    private Integer userId;
}
