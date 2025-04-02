package com.tuna.gomen.bookMarkandLike.query.service;

import com.tuna.gomen.mapper.LikeMapper;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeMapper likeMapper;

    public LikeService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    public int getLikeCount(int postId) {
        return likeMapper.getLikeCountByPostId(postId);
    }

}