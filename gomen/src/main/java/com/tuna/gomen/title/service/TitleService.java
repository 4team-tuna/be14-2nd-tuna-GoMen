package com.tuna.gomen.title.service;

import com.tuna.gomen.title.entity.Title;
import java.util.List;

public interface TitleService {

    Title createTitle(String titleName); // 칭호 생성
    Title updateTitle(Integer titleId, String newTitleName); // 칭호 수정
    List<Title> getAllTitles(); // 모든 칭호 조회

}
