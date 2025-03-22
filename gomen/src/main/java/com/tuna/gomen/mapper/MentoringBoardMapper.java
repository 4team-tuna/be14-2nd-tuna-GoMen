package com.tuna.gomen.mapper;

import com.tuna.gomen.mentoringBoard.query.domain.entity.MentoringBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MentoringBoardMapper {
    List<MentoringBoard> selectLeftOverQuestion(Integer userId);
}
