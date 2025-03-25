package com.tuna.gomen.board.command.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.file.entity.BoardFile;
import com.tuna.gomen.file.repository.BoardFileRepository;
import com.tuna.gomen.file.Service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BoardService2Test {

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private BoardFileRepository boardFileRepository;

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private BoardService2 boardService;

    @Test
    void 소프트_딜리트_테스트() {
        // Given
        Board board = new Board();
        board.setIsDeleted("N");
        when(boardRepository.findById(anyInt())).thenReturn(Optional.of(board));
        when(boardRepository.save(any(Board.class))).thenReturn(board);

        // When
        boardService.softDeleteBoard(1);

        // Then
        assertEquals("Y", board.getIsDeleted());
        verify(boardRepository, times(1)).save(board);
    }
}