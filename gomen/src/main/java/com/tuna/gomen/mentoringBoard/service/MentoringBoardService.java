package com.tuna.gomen.mentoringBoard.service;

import com.tuna.gomen.mentoringBoard.dto.MentoringBoardDTO;

import java.util.List;

public interface MentoringBoardService {
    List<MentoringBoardDTO> selectLeftOverQuestion(Integer userId);
}
