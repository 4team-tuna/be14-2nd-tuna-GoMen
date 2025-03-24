package com.tuna.gomen.title.repository;

import com.tuna.gomen.title.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleListRepository extends JpaRepository<Title, Integer> {

}
