package com.tuna.gomen.comment.command.dto;

import com.tuna.gomen.comment.command.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Integer id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String isBlinded;
    private String isDeleted;
    private Integer userId;
    private Integer postId;
    private Integer parentCommentId;
    //d주석주석
    public static CommentDTO fromEntity(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .isBlinded(comment.getIsBlinded())
                .isDeleted(comment.getIsDeleted())
                .userId(comment.getUser().getUserId())
                .postId(comment.getBoard() != null ? comment.getBoard().getPostId() : null)
                .parentCommentId(comment.getParentComment() != null ? comment.getParentComment().getId() : null)
                .build();
    }
}
