package com.tuna.gomen.mapper;

import com.tuna.gomen.board.query.entity.BoardEntity;
import com.tuna.gomen.board.query.entity.CommentEntity;
import com.tuna.gomen.board.query.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 전체 조회
    List<BoardEntity> findAll();

    // 특정 사용자가 게시한 게시글 조회
    List<BoardEntity> findByUserId(Long userId);

    // 특정 카테고리의 게시글 조회
    List<BoardEntity> findByCategory(String category);

    // 특정 키워드가 포함된 제목으로 게시글 조회
    List<BoardEntity> findByTitleKeyword(String keyword);

    // 특정 게시글의 작성자 정보 조회
    UserEntity findAuthorByPostId(@Param("postId") Long postId);

    // 특정 게시글의 댓글 조회
    List<CommentEntity> findCommentsByPostId(@Param("postId") Long postId);

    //특정 게시글 조회
    BoardEntity getBoardDetails(int postId);
}

