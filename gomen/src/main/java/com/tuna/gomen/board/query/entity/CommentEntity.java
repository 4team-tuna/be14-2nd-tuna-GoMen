package com.tuna.gomen.board.query.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentEntity {
    private Long commentId;
    private String commentContent;
    private LocalDateTime createdAt;
    private Long userId;
    private Long postId;
}

