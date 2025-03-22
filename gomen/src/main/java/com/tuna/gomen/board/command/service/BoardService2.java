package com.tuna.gomen.board.command.service;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.file.entity.BoardFile;
import com.tuna.gomen.file.repository.BoardFileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService2 {

    private final BoardRepository boardRepository;
    private final BoardFileRepository boardFileRepository;

    @Autowired
    public BoardService2(BoardRepository boardRepository,BoardFileRepository boardFileRepository) {
        this.boardRepository = boardRepository;
        this.boardFileRepository = boardFileRepository;
    }

    private static final String UPLOAD_DIR = "C:/uploads/"; // 파일 저장 경로

    // 게시글 작성 (파일 포함)
    @Transactional
    public Board createBoard(Board board, List<MultipartFile> files) throws IOException {
        Board savedBoard = boardRepository.save(board);

        if (files != null && !files.isEmpty()) {
            List<BoardFile> savedFiles = uploadFiles(files, savedBoard);
            boardFileRepository.saveAll(savedFiles);
        }

        return boardRepository.save(savedBoard);
    }

    // 게시글 수정 (파일 포함)
    @Transactional
    public Board updateBoard(Integer postId, Board updatedBoard, List<MultipartFile> files) throws IOException {
        Board existingBoard = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid postId"));

        existingBoard.setTitle(updatedBoard.getTitle());
        existingBoard.setContent(updatedBoard.getContent());
        existingBoard.setModifiedAt(LocalDateTime.now());

        // 기존 파일 삭제 후 새로운 파일 저장
        boardFileRepository.deleteAllByBoard(existingBoard);

        if (files != null && !files.isEmpty()) {
            List<BoardFile> savedFiles = uploadFiles(files, existingBoard);
            boardFileRepository.saveAll(savedFiles);
        }

        return existingBoard;
    }

    // 파일 업로드 및 저장 (Board와 연결)
    public List<BoardFile> uploadFiles(List<MultipartFile> files, Board board) throws IOException {
        List<BoardFile> fileList = new ArrayList<>();

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String savedFilename = UUID.randomUUID().toString() + "_" + originalFilename;
            String filePath = UPLOAD_DIR + savedFilename;

            // 파일 저장
            File destFile = new File(filePath);
            file.transferTo(destFile);

            // DB 저장용 파일 엔티티 생성
            BoardFile boardFile = new BoardFile();
            boardFile.setAddress(filePath);
            boardFile.setBoard(board); // 📌 Board와 연결
            fileList.add(boardFile);
        }

        return fileList;
    }

    // 게시글 삭제
    @Transactional
    public void deleteBoard(Integer postId) {
        Board existingBoard = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid postId"));
        existingBoard.setIsDeleted("Y");
        boardRepository.save(existingBoard);
    }

    // 게시글에 해당하는 파일을 가져오는 메서드 추가
    public List<BoardFile> getFilesByBoardId(Integer postId) {
        return boardFileRepository.findByBoard_PostId(postId);  // Board의 postId를 기준으로 파일 조회
    }

}
