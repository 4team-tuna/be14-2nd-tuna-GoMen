package com.tuna.gomen.title.service;

import com.tuna.gomen.title.entity.Title;
import com.tuna.gomen.title.repository.TitleRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;

    public TitleServiceImpl(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    // 칭호 생성
    @Transactional
    @Override
    public Title createTitle(String titleName) {
        if (titleRepository.existsByTitleName(titleName)) {
            throw new IllegalArgumentException("이미 존재하는 칭호입니다.");
        }
        Title title = Title.builder()
                .titleName(titleName)
                .build();
        return titleRepository.save(title);
    }

    // 칭호 수정
    @Transactional
    @Override
    public Title updateTitle(Integer titleId, String newTitleName) {
        Title title = titleRepository.findById(titleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 칭호입니다."));
        title.setTitleName(newTitleName);
        return titleRepository.save(title);
    }

    // 모든 칭호 조회
    @Override
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

}