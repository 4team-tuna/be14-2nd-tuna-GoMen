package com.tuna.gomen.board.command.service;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.file.entity.BoardFile;
import com.tuna.gomen.file.repository.BoardFileRepository;
import com.tuna.gomen.user.command.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import com.tuna.gomen.user.command.repository.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.tuna.gomen.file.Service.FileStorageService;

@Service
public class BoardService2 {

    private final BoardRepository boardRepository;
    private final BoardFileRepository boardFileRepository;
    private final FileStorageService fileStorageService;

    @Autowired
    public BoardService2(BoardRepository boardRepository,
                         BoardFileRepository boardFileRepository,
                         FileStorageService fileStorageService) {
        this.boardRepository = boardRepository;
        this.boardFileRepository = boardFileRepository;
        this.fileStorageService = fileStorageService;
    }



    @Transactional
    public Board createBoard(Board board, List<MultipartFile> files) throws IOException {
        // 📌 1️⃣ 먼저 게시글 저장
        Board savedBoard = boardRepository.save(board);

        // 📌 2️⃣ 파일이 있으면 업로드 후 저장
        List<BoardFile> savedFiles = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                String filePath = saveFile(file); // 파일 저장 후 경로 반환

                // 📌 3️⃣ BoardFile 생성 후 Board와 연결
                BoardFile boardFile = new BoardFile();
                boardFile.setAddress(filePath);
                boardFile.setBoard(savedBoard); // ✅ 저장된 Board 객체와 연결
                boardFileRepository.save(boardFile); // ✅ DB에 저장

                savedFiles.add(boardFile); // 리스트에 추가
            }
        }

        return savedBoard; // ✅ 저장된 게시글 반환
    }

    // 📌 파일 저장 메서드
    private String saveFile(MultipartFile file) throws IOException {
        String uploadDir = "C:/uploads/"; // 파일 저장 경로
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);
        Files.write(path, file.getBytes()); // 파일 저장
        return path.toString(); // 저장된 파일 경로 반환
    }


    public Board updateBoard(Board board) {
        return boardRepository.save(board);
    }




    public List<BoardFile> uploadFiles(List<MultipartFile> files, Board board) throws IOException {
        List<BoardFile> savedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            // 1️⃣ 파일을 로컬 저장소에 저장
            String storedFilePath = fileStorageService.storeFile(file);

            // 2️⃣ 새로운 파일 엔티티 생성
            BoardFile boardFile = new BoardFile();
            boardFile.setBoard(board);  // ✅ 게시글과 연결
            boardFile.setAddress(storedFilePath);

            // 3️⃣ DB 저장
            boardFile = boardFileRepository.save(boardFile);
            savedFiles.add(boardFile);
        }

        return savedFiles; // 새로 저장된 파일 리스트 반환
    }


    public void deleteFilesByIds(List<Integer> fileIds) {
        for (Integer fileId : fileIds) {
            BoardFile boardFile = boardFileRepository.findById(fileId)
                    .orElseThrow(() -> new RuntimeException("파일을 찾을 수 없습니다. fileId: " + fileId));

            String filePath = boardFile.getAddress();
            fileStorageService.deleteFile(filePath);  // ✅ 실제 파일 삭제
            boardFileRepository.delete(boardFile);  // ✅ DB에서 파일 삭제

            System.out.println("🗑 파일 삭제 완료: " + filePath);
        }
    }





    // 게시글에 해당하는 파일을 가져오는 메서드 추가
    public List<BoardFile> getFilesByBoardId(Integer postId) {
        return boardFileRepository.findByBoard_PostId(postId);  // Board의 postId를 기준으로 파일 조회
    }

    // 게시글 조회 메서드 (postId로 게시글을 찾음)
    public Board findBoardById(Integer postId) {
        return boardRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다. postId: " + postId));
    }

    @Transactional
    public List<BoardFile> saveFiles(Board board, List<MultipartFile> files) throws IOException {
        List<BoardFile> savedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            String storedFilePath = fileStorageService.storeFile(file);
            System.out.println("📁 저장된 파일 경로: " + storedFilePath);  // ✅ 저장 경로 확인

            BoardFile boardFile = new BoardFile();
            boardFile.setBoard(board);
            boardFile.setAddress(storedFilePath);

            boardFile = boardFileRepository.save(boardFile);  // ✅ 파일 DB 저장
            System.out.println("✅ 파일 DB 저장 완료: " + boardFile.getFileId()); // ✅ 저장된 ID 확인

            savedFiles.add(boardFile);
        }

        return savedFiles;  // ✅ 저장된 파일 리스트 반환
    }






    public void softDeleteBoard(Integer postId) {
        Board board = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        // 게시글 삭제 처리: isDeleted를 "Y"로 설정
        board.setIsDeleted("Y");  // "Y"로 변경하여 삭제된 상태로 표시
        boardRepository.save(board);  // 변경사항 저장
    }

}
