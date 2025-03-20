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

    // 기존 Entity 조회 메서드 (필요시 보존)
    public List<BoardEntity> getAllBoards() {
        return boardMapper.findAll();
    }

    // Entity를 DTO로 변환하는 메서드 추가
    public List<BoardDto> getAllBoardDtos() {
        List<BoardEntity> entities = boardMapper.findAll();
        return entities.stream().map(entity -> {
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
        }).collect(Collectors.toList());
    }
}
