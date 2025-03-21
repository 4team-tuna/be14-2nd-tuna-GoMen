package com.tuna.gomen.mentoringBoard;

import java.util.List;

public interface MentoringBoardService {
    List<MentoringBoardDTO> selectLeftOverQuestion(Integer userId);
}
