package com.tuna.gomen.mentoringBoard.command.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerRequest {
    private Integer questionId;
    private String answerContent;
    private Integer refAnswerId;
    private List<MultipartFile> files;
}

