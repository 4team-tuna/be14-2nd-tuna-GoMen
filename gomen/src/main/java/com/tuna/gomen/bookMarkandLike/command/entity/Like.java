package com.tuna.gomen.bookMarkandLike.command.entity;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_like")
@IdClass(BookmarkId.class)
@Getter
@Setter
public class Like {

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