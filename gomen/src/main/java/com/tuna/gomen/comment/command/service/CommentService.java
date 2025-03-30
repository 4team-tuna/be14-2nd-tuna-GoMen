package com.tuna.gomen.comment.command.service;


import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.comment.command.dto.CommentDTO;
import com.tuna.gomen.comment.command.entity.Comment;
import com.tuna.gomen.comment.command.repository.CommentRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    // 댓글 작성
    @Transactional
    public CommentDTO createComment(CommentDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Board board = null;
        if (dto.getPostId() != null) {
            board = boardRepository.findById(dto.getPostId())
                    .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        }

        Comment parentComment = null;
        if (dto.getParentCommentId() != null) {
            parentComment = commentRepository.findById(dto.getParentCommentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent comment not found"));
        }

        Comment comment = Comment.builder()
                .content(dto.getContent())
                .createdAt(LocalDateTime.now())
                .isBlinded("N")
                .isDeleted("N")
                .user(user)
                .board(board)
                .parentComment(parentComment)
                .build();

        return CommentDTO.fromEntity(commentRepository.save(comment));
    }

    // 댓글 수정
    @Transactional
    public CommentDTO updateComment(Integer commentId, String newContent) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        comment.setContent(newContent);
        comment.setUpdatedAt(LocalDateTime.now());

        return CommentDTO.fromEntity(commentRepository.save(comment));
    }

    // 댓글 삭제 (논리 삭제)
    @Transactional
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        comment.setIsDeleted("Y");
        comment.setUpdatedAt(LocalDateTime.now());

        commentRepository.save(comment);
    }

    // 특정 게시글의 댓글 조회
    public List<CommentDTO> getCommentsByPostId(Integer postId) {
        List<Comment> comments = commentRepository.findByBoard_PostIdAndIsDeleted(postId, "N");
        return comments.stream().map(CommentDTO::fromEntity).collect(Collectors.toList());
    }
}