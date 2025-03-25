package com.tuna.gomen.mentoringBoard.command.dto;

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
public class QuestionRequest {
    private String questionContent;
    private Integer mentoringSpaceId;
    private List<MultipartFile> files;
}
