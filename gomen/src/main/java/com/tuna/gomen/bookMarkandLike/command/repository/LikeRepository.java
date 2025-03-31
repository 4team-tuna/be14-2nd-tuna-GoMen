package com.tuna.gomen.bookMarkandLike.command.repository;

import com.tuna.gomen.bookMarkandLike.command.entity.Like;
import com.tuna.gomen.bookMarkandLike.command.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {

    // 특정 사용자의 특정 게시글 북마크 찾기
    Optional<Like> findByUserIdAndPostId(Integer userId, Integer postId);

    // 특정 사용자의 특정 게시글 북마크 삭제
    void deleteByUserIdAndPostId(Integer userId, Integer postId);

}
