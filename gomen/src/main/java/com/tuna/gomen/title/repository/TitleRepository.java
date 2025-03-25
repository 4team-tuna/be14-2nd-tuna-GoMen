package com.tuna.gomen.title.repository;

import com.tuna.gomen.title.entity.Title;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {

    // 특정 타이틀 조회
    Optional<Title> findByTitleName(String titleName);

    // 중복 확인
    boolean existsByTitleName(String titleName);
}
