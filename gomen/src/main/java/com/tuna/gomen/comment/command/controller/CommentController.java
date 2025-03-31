package com.tuna.gomen.comment.command.controller;


import com.tuna.gomen.comment.command.dto.CommentDTO;
import com.tuna.gomen.comment.command.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("gomen/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO dto) {
        return ResponseEntity.ok(commentService.createComment(dto));
    }

    // 댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Integer id, @RequestBody String newContent) {
        return ResponseEntity.ok(commentService.updateComment(id, newContent));
    }

    // 댓글 삭제 (논리 삭제)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

}