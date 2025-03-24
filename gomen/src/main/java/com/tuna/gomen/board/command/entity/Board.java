package com.tuna.gomen.board.command.entity;

import com.tuna.gomen.file.entity.BoardFile;
import com.tuna.gomen.user.command.entity.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(nullable = false)
    private Integer category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private String isBlinded = "N";

    @Column(nullable = false)
    private String isDeleted = "N";

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 📌 파일 리스트 추가 (Board <-> BoardFile 연결)
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardFile> files;

    // 📌 파일 추가 메서드
    public void addFile(BoardFile file) {
        file.setBoard(this);
        this.files.add(file);
    }
}
