package com.tuna.gomen.board.repository;

<<<<<<< HEAD
public class BoardRepository {
=======

import com.tuna.gomen.board.command.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 추가적인 메소드 구현이 필요하다면 여기에 추가
>>>>>>> d64258bbdfba9da895ffde5c347327bf1a8d3abc
}
