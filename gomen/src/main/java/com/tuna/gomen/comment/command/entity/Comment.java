package com.tuna.gomen.comment.command.entity;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    @Column(name = "comment_content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_blinded", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'N'")
    private String isBlinded;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'N'")
    private String isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_comment_id")
    private Comment parentComment;

    // 댓글 신고시 해당 회원에게 벌점 부여 위해 필요-석현
    public Integer getWriterId() {
        return user != null ? user.getUserId() : null;
    }
}