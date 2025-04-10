package com.tuna.userservice.query.mapper;

import com.tuna.userservice.query.dto.UserQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserQueryDTO> selectAllUsers();

    UserQueryDTO selectUserByUserId(int userId);

    UserQueryDTO selectUserByLoginId(String loginId);

    List<UserQueryDTO> selectUserByNickname(String nickname);

    UserQueryDTO selectUserByPostId(int postId);

    UserQueryDTO selectUserByCommentId(int commentId);

    UserQueryDTO selectUserByQuestionId(int questionId);

    UserQueryDTO selectUserByAnswerId(int answerId);
}
