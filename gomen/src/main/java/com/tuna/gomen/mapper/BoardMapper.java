package com.tuna.gomen.mapper;

import com.tuna.gomen.board.domain.entity.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 전체 조회
    List<BoardEntity> findAll();

    // 특정 사용자가 게시한 게시글 조회
    List<BoardEntity> findByUserId(Long userId);

    // 특정 카테고리의 게시글 조회
    List<BoardEntity> findByCategory(String category);

    // 특정 키워드가 포함된 제목으로 게시글 조회
    List<BoardEntity> findByTitleKeyword(String keyword);
}
