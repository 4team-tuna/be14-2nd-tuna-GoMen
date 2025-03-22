package com.tuna.gomen.file.entity;

import com.tuna.gomen.board.command.entity.Board;
import jakarta.persistence.*;

@Entity
public class BoardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board; // 게시글과 연결

}