package com.tuna.gomen.mentoringBoard.query.service;

import com.tuna.gomen.mentoringBoard.query.dto.MentoringBoardDTO;

import java.util.List;

public interface MentoringBoardService {
    List<MentoringBoardDTO> selectLeftOverQuestion(Integer userId);
}
