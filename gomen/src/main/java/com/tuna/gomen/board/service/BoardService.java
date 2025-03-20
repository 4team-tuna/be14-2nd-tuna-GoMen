package com.tuna.gomen.board.service;

import com.tuna.gomen.board.domain.entity.BoardEntity;
import com.tuna.gomen.board.dto.BoardDto;
import com.tuna.gomen.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 기존 전체 조회
    public List<BoardDto> getAllBoardDtos() {
        return boardMapper.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 사용자의 게시글 조회
    public List<BoardDto> getBoardsByUserId(Long userId) {
        return boardMapper.findByUserId(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 카테고리의 게시글 조회
    public List<BoardDto> getBoardsByCategory(String category) {
        return boardMapper.findByCategory(category).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 키워드가 포함된 제목의 게시글 조회
    public List<BoardDto> getBoardsByTitleKeyword(String keyword) {
        return boardMapper.findByTitleKeyword(keyword).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Entity -> DTO 변환 메서드
    private BoardDto convertToDto(BoardEntity entity) {
        BoardDto dto = new BoardDto();
        dto.setPostId(entity.getPostId());
        dto.setCategory(entity.getCategory());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setModifiedAt(entity.getModifiedAt());
        dto.setIsBlinded(entity.getIsBlinded());
        dto.setIsDeleted(entity.getIsDeleted());
        dto.setUserId(entity.getUserId());
        return dto;
    }
}
