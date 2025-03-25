package com.tuna.userservice.mapper;

import com.tuna.userservice.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> selectAllUsers();

    UserDTO selectUserByUserId(int userId);

    UserDTO selectUserByLoginId(String loginId);

    List<UserDTO> selectUserByNickname(String nickname);

    UserDTO selectUserByPostId(int postId);

    UserDTO selectUserByCommentId(int commentId);

    UserDTO selectUserByQuestionId(int questionId);

    UserDTO selectUserByAnswerId(int answerId);
}
