package com.tuna.gomen.board.controller;

import com.tuna.gomen.board.dto.BoardDto;
import com.tuna.gomen.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
