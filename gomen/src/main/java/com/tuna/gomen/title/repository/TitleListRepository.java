package com.tuna.gomen.title.repository;

import com.tuna.gomen.title.entity.TitleList;
import com.tuna.gomen.title.entity.TitleListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleListRepository extends JpaRepository<TitleList, TitleListId> {
    boolean existsByUserIdAndTitleId(Integer userId, Integer titleId);
}
