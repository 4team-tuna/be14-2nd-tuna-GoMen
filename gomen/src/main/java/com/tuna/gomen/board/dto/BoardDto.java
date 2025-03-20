package com.tuna.gomen.board.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {
    private Long postId;
    private String category;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String isBlinded;
    private String isDeleted;
    private Long userId;
}

