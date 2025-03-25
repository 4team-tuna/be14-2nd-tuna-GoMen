package com.tuna.gomen.file.repository;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.file.entity.BoardFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardFileRepository extends JpaRepository<BoardFile, Integer> {
    List<BoardFile> findByBoard(Board board);

    void deleteAllByBoard(Board board);


    List<BoardFile> findByBoard_PostId(Integer postId);

}
