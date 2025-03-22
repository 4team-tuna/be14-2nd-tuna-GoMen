package com.tuna.gomen.mentoringBoard.query.service;

import com.tuna.gomen.mapper.MentoringBoardMapper;
import com.tuna.gomen.mentoringBoard.query.domain.entity.MentoringBoard;
import com.tuna.gomen.mentoringBoard.query.dto.MentoringBoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentoringBoardServiceImpl implements MentoringBoardService {

    private final MentoringBoardMapper mentoringBoardMapper;

    @Autowired
    public MentoringBoardServiceImpl(MentoringBoardMapper mentoringBoardMapper) {
        this.mentoringBoardMapper = mentoringBoardMapper;
    }

    @Override
    public List<MentoringBoardDTO> selectLeftOverQuestion(Integer userId) {
        List<MentoringBoard> mentoringBoardQuestions = mentoringBoardMapper.selectLeftOverQuestion(userId);

        return mentoringBoardQuestions.stream()
                .map(mentoringBoard -> new MentoringBoardDTO(
                        mentoringBoard.getUserId(),
                        mentoringBoard.getLeftOverQuestions()
                ))
                .collect(Collectors.toList());
    }
}
