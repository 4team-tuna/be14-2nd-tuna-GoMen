package com.tuna.gomen.mapper;

import com.tuna.gomen.mentoringBoard.MentoringBoard;

import java.util.List;

public interface MentoringBoardMapper {
    List<MentoringBoard> getMentoringBoardByQuestions(Integer userId);
}
