package com.tuna.gomen.comment.command.repository;

import com.tuna.gomen.comment.command.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer > {

    List<Comment> findByBoard_PostIdAndIsDeleted(Integer postId, String isDeleted);

}
