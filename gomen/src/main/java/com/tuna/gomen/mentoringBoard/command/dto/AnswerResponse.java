package com.tuna.gomen.mentoringBoard.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private Integer answerId;
    private String answerContent;
    private LocalDateTime answerCreatedTime;
    private Integer questionId;
    private Integer answerMemberId;
    private Integer mentoringSpaceId;
    private Integer refAnswerId;
    private String isDeleted;
    private List<String> filePaths;
}
