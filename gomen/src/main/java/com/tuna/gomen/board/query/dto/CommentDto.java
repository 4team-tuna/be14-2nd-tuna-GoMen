package com.tuna.gomen.board.query.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long commentId;
    private String commentContent;
    private LocalDateTime createdAt;
    private Long userId;
    private String userNickname; // 댓글 작성자 닉네임
}
