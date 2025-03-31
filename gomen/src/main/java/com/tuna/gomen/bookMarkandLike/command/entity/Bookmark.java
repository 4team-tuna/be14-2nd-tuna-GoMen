package com.tuna.gomen.bookMarkandLike.command.entity;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_bookmark")
@IdClass(BookmarkId.class)
@Getter
@Setter
public class Bookmark {

    @Id
    @Column(name = "post_id")
    private Integer postId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
