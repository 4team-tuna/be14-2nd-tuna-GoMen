package com.tuna.gomen.mapper;

import com.tuna.gomen.board.domain.entity.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardEntity> findAll();
}
