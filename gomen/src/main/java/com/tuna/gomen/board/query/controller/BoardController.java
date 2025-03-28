package com.tuna.gomen.board.query.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuna.gomen.board.command.dto.BoardDTO;
import com.tuna.gomen.board.command.entity.Board;

import com.tuna.gomen.board.command.service.BoardService2;
import com.tuna.gomen.file.entity.BoardFile;
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

    private final BoardService2 boardService2;
    private final UserService2 userService2;

    @Autowired
    public BoardController(BoardService2 boardService2,
                            UserService2 userService2) {
        this.boardService2 = boardService2;
        this.userService2 = userService2;
    }


    @PostMapping
    public BoardDTO createBoard(@RequestParam("board") String boardJson,
                                @RequestParam(value = "files", required = false) List<MultipartFile> files) throws IOException {
        // JSON을 BoardDTO로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        BoardDTO boardDTO = objectMapper.readValue(boardJson, BoardDTO.class);

        System.out.println("BoardDTO: " + boardDTO);
        System.out.println("Files: " + files);

        // 📌 1. 유저 ID를 이용해 유저 가져오기
        User user = userService2.getUserById(boardDTO.getUserId()); // 유저 ID로 조회
        if (user == null) {
            throw new RuntimeException("유효하지 않은 사용자 ID입니다.");
        }

        // 📌 2. 게시글 객체 생성 및 유저 설정
        Board board = new Board();
        board.setCategory(boardDTO.getCategory());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setUser(user); // 유저 설정

        // 📌 3. 먼저 게시글을 저장해야 Board 객체가 DB에 존재함
        Board savedBoard = boardService2.createBoard(board, null);

        // 📌 4. 파일 업로드 및 저장
        List<BoardFile> savedFiles = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            savedFiles = boardService2.uploadFiles(files, savedBoard);
        }

        // 📌 5. DTO 변환 (파일 정보 포함)
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


