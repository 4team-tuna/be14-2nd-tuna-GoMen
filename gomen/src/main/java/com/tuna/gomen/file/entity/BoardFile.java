package com.tuna.gomen.file.entity;

import com.tuna.gomen.board.command.entity.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tbl_board_file")
public class    BoardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board; // 게시글과 연결


}