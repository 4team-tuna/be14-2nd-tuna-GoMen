package com.tuna.gomen.board.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardEntity {
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