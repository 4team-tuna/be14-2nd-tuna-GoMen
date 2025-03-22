package com.tuna.gomen.board.query.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuna.gomen.board.command.dto.BoardDTO;
import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.board.command.service.BoardService2;
import com.tuna.gomen.board.query.dto.BoardDto;
import com.tuna.gomen.board.query.dto.CommentDto;
import com.tuna.gomen.board.query.dto.UserDto;
import com.tuna.gomen.board.query.service.BoardService;
import com.tuna.gomen.file.entity.BoardFile;
import com.tuna.gomen.file.repository.BoardFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gomen/boards")
public class BoardController {

    private final BoardService boardService;
    private final BoardService2 boardService2;
    private final BoardFileRepository boardFileRepository;

    @Autowired
    public BoardController(BoardService boardService, BoardService2 boardService2, BoardFileRepository boardFileRepository) {
        this.boardService = boardService;
        this.boardService2 = boardService2;
        this.boardFileRepository = boardFileRepository;
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

    /// 설명.아래부턴JPA(DML)/////////////////////////////////
    /// 설명.아래부턴JPA(DML)/////////////////////////////////
    /// 설명.아래부턴JPA(DML)/////////////////////////////////
    /// 설명.아래부턴JPA(DML)/////////////////////////////////
    /// /// 설명.아래부턴JPA(DML)/////////////////////////////////
    /// /// 설명.아래부턴JPA(DML)/////////////////////////////////
    ///
    // 게시글 작성 (파일 포함)
    @PostMapping
    public BoardDTO createBoard(@RequestParam("board") String boardJson,
                                @RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {
        // JSON을 BoardDTO로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        BoardDTO boardDTO = objectMapper.readValue(boardJson, BoardDTO.class);

        System.out.println("BoardDTO: " + boardDTO);
        System.out.println("Files: " + files);

        Board board = new Board();
        board.setCategory(boardDTO.getCategory());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());

        // 📌 1. 먼저 게시글을 저장해야 Board 객체가 DB에 존재함
        Board savedBoard = boardService2.createBoard(board, null);

        // 파일 업로드 및 저장
        List<BoardFile> savedFiles = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            savedFiles = boardService2.uploadFiles(files, savedBoard);
        }

        // 4️⃣ DTO 변환 (파일 정보 포함)
        return BoardDTO.fromEntity(savedBoard, savedFiles);
    }


    public List<BoardFile> getFilesByBoardId(Integer postId) {
        return boardFileRepository.findByBoard_PostId(postId);
    }


    @PutMapping("/{postId}")
    public BoardDTO updateBoard(@PathVariable Integer postId,
                                @RequestPart("board") BoardDTO boardDTO,
                                @RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException {
        Board board = new Board();
        board.setCategory(boardDTO.getCategory());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());

        // 📌 수정된 게시글과 파일을 함께 처리
        Board updatedBoard = boardService2.updateBoard(postId, board, files);

        // 📌 수정된 파일 정보 가져오기
        List<BoardFile> updatedFiles = boardService2.getFilesByBoardId(updatedBoard.getPostId());

        return BoardDTO.fromEntity(updatedBoard, updatedFiles); // 🔥 수정된 부분 (파일 리스트 추가)
    }


    // 게시글 삭제
    @DeleteMapping("/{postId}")
    public void deleteBoard(@PathVariable Integer postId) {
        boardService2.deleteBoard(postId);
    }



}


