package com.tuna.gomen.title.service;

import com.tuna.gomen.title.entity.Title;
import com.tuna.gomen.title.entity.TitleList;
import com.tuna.gomen.title.entity.TitleListId;
import com.tuna.gomen.title.repository.TitleListRepository;
import com.tuna.gomen.title.repository.TitleRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TitleListServiceImpl implements TitleListService {

    @Autowired
    private TitleListRepository titleListRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addTitleToUser(Integer userId, Integer titleId) {
        // User와 Title을 각각 찾아오기
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Title title = titleRepository.findById(titleId)
                .orElseThrow(() -> new RuntimeException("Title not found"));

        // 이미 같은 userId와 titleId가 존재하는지 확인
        boolean exists = titleListRepository.existsByUserIdAndTitleId(userId, titleId);
        if (exists) {
            throw new IllegalArgumentException("Title already assigned to the user.");
        }

        // TitleList 객체 생성
        TitleList titleList = new TitleList();
        titleList.setUserId(userId);  // userId 주입
        titleList.setTitleId(titleId);  // titleId 주입
        titleList.setUser(user);  // User 객체 주입
        titleList.setTitle(title);  // Title 객체 주입

        // TitleList 저장
        try {
            titleListRepository.save(titleList);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Failed to assign title to user", e);
        }
    }

}
