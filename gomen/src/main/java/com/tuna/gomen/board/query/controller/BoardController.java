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
import com.tuna.gomen.user.command.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.tuna.gomen.user.command.service.UserService2;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gomen/boards")
public class BoardController {

    private final BoardService boardService;
    private final BoardService2 boardService2;
    private final UserService2 userService2;
    private final BoardFileRepository boardFileRepository;

    @Autowired
    public BoardController(BoardService boardService, BoardService2 boardService2,
                            UserService2 userService2, BoardFileRepository boardFileRepository) {
        this.boardService = boardService;
        this.boardService2 = boardService2;
        this.userService2 = userService2;
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


        // DB에서 ID=1인 유저 가져오기
        User user = userService2.getDefaultUser();
        board.setUser(user);  // 게시글 작성자 설정

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


    @PutMapping("/{postId}")
    public BoardDTO updateBoard(@PathVariable Integer postId,
                                @RequestPart("board") String boardJson,
                                @RequestPart(value = "files", required = false) List<MultipartFile> files,
                                @RequestParam(value = "deleteFileIds", required = false) List<Integer> deleteFileIds) throws IOException {
        // JSON -> DTO 변환
        ObjectMapper objectMapper = new ObjectMapper();
        BoardDTO boardDTO = objectMapper.readValue(boardJson, BoardDTO.class);

        System.out.println("BoardDTO: " + boardDTO);
        System.out.println("Files: " + files);
        System.out.println("Delete File IDs: " + deleteFileIds);

        // 📌 1. 기존 게시글 조회
        Board existingBoard = boardService2.findBoardById(postId);

        // 📌 2. 게시글 정보 업데이트
        existingBoard.setCategory(boardDTO.getCategory());
        existingBoard.setTitle(boardDTO.getTitle());
        existingBoard.setContent(boardDTO.getContent());
        existingBoard.setModifiedAt(LocalDateTime.now());

        // 3. 삭제할 파일이 있으면 삭제
        if (deleteFileIds != null && !deleteFileIds.isEmpty()) {
            boardService2.deleteFilesByIds(deleteFileIds);
        }

        // 4. 새로운 파일이 있는 경우만 추가
        if (files != null && !files.isEmpty()) {
            List<MultipartFile> validFiles = files.stream()
                    .filter(file -> file.getSize() > 0)  // 🚀 **빈 파일 필터링**
                    .toList();

            if (!validFiles.isEmpty()) {  // 🚀 **진짜 파일이 있을 때만 저장**
                List<BoardFile> newFiles = boardService2.saveFiles(existingBoard, validFiles);
                existingBoard.getFiles().addAll(newFiles);
            }
        }


        // 📌 5. 수정된 게시글 저장
        Board updatedBoard = boardService2.updateBoard(existingBoard);

        // 📌 6. 모든 파일 정보 가져오기 (기존 파일 + 새로운 파일)
        List<BoardFile> allFiles = boardService2.getFilesByBoardId(updatedBoard.getPostId());

        return BoardDTO.fromEntity(updatedBoard, allFiles);
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deleteBoard(@PathVariable Integer postId) {
        boardService2.softDeleteBoard(postId);  // soft delete 처리
        return ResponseEntity.status(HttpStatus.OK).body("Board has been successfully deleted.");

    }




}


