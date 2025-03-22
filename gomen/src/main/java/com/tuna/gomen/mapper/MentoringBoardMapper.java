package com.tuna.gomen.mapper;

import com.tuna.gomen.mentoringBoard.query.domain.entity.MentoringBoard;

import java.util.List;

public interface MentoringBoardMapper {
    List<MentoringBoard> selectLeftOverQuestion(Integer userId);
}
