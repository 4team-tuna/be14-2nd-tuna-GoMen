package com.tuna.gomen.mentoringBoard.command.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class QuestionResponse {
    private Integer questionId;
    private String questionContent;
    private LocalDateTime questionCreatedTime;
    private Integer memberId;
    private Integer mentoringSpaceId;
    private String isDeleted;
    private List<String> filePaths;
}
