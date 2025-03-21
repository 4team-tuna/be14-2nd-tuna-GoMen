package com.tuna.gomen.user;

import com.tuna.gomen.mapper.UserMapper;
import com.tuna.gomen.user.UserDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDTO> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    public UserDTO selectUserByUserId(int userId){
        return userMapper.selectUserByUserId(userId);
    }

    public UserDTO selectUserByLoginId(String loginId) {
        return userMapper.selectUserByLoginId(loginId);
    }

    public List<UserDTO> selectUserByNickname(String nickname){
        return userMapper.selectUserByNickname(nickname);
    }

    public UserDTO selectUserByPostId(int postId) {
        return userMapper.selectUserByPostId(postId);
    }

    public UserDTO selectUserByCommentId(int commentId) {
        return userMapper.selectUserByCommentId(commentId);
    }

    public UserDTO selectUserByQuestionId(int questionId) {
        return userMapper.selectUserByQuestionId(questionId);
    }

    public UserDTO selectUserByAnswerId(int answerId) {
        return userMapper.selectUserByAnswerId(answerId);
    }
}
