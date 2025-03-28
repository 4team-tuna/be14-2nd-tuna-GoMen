package com.tuna.gomen.bookMarkandLike.command.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class LikeId implements Serializable {
    private Integer postId;
    private Integer userId;

    public LikeId() {}

    public LikeId(Integer postId, Integer userId) {
        this.postId = postId;
        this.userId = userId;
    }
}