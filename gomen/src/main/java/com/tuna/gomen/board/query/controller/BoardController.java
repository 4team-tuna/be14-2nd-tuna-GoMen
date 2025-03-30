package com.tuna.gomen.board.query.controller;

import com.tuna.gomen.board.query.dto.BoardDto;
import com.tuna.gomen.board.query.dto.CommentDto;
import com.tuna.gomen.board.query.dto.UserDto;
import com.tuna.gomen.board.query.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/gomen/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 전체 게시글 조회
    @GetMapping
    public List<BoardDto> getBoards() {
        return boardService.getAllBoardDtos();
    }

    // 특정 사용자의 게시글 조회
    @GetMapping("/user")
    public List<BoardDto> getBoardsByUserId(@RequestParam Long userId) {
        return boardService.getBoardsByUserId(userId);
    }

    // 특정 카테고리의 게시글 조회
    @GetMapping("/category")
    public List<BoardDto> getBoardsByCategory(@RequestParam String category) {
        return boardService.getBoardsByCategory(category);
    }

    // 특정 키워드가 포함된 제목으로 게시글 조회
    @GetMapping("/search")
    public List<BoardDto> getBoardsByTitleKeyword(@RequestParam String keyword) {
        return boardService.getBoardsByTitleKeyword(keyword);
    }


    //특정 게시글 내용 조회
    @GetMapping("/{postId}")
    public ResponseEntity<BoardDto> getBoardDetails(@PathVariable int postId) {
        BoardDto board = boardService.getBoardDetails(postId);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // 특정 게시글의 작성자 회원정보 조회
    @GetMapping("/{postId}/author")
    public ResponseEntity<UserDto> getAuthorByPostId(@PathVariable Long postId) {
        UserDto author = boardService.getAuthorByPostId(postId);
        if (author == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(author);
    }

    // 특정 게시글의 댓글 조회
    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable Long postId) {
        List<CommentDto> comments = boardService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }


}


