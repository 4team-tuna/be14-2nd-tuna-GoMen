package com.tuna.userservice.query.service;

import com.tuna.userservice.query.dto.UserQueryDTO;
import com.tuna.userservice.command.repository.UserRepository;
import com.tuna.userservice.query.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserQueryService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserQueryService(UserMapper userMapper, UserRepository userRepository, ModelMapper modelMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserQueryDTO> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    public UserQueryDTO selectUserByUserId(int userId){
        return userMapper.selectUserByUserId(userId);
    }

    public UserQueryDTO selectUserByLoginId(String loginId) {
        return userMapper.selectUserByLoginId(loginId);
    }

    public List<UserQueryDTO> selectUserByNickname(String nickname){
        return userMapper.selectUserByNickname(nickname);
    }

    public UserQueryDTO selectUserByPostId(int postId) {
        return userMapper.selectUserByPostId(postId);
    }

    public UserQueryDTO selectUserByCommentId(int commentId) {
        return userMapper.selectUserByCommentId(commentId);
    }

    public UserQueryDTO selectUserByQuestionId(int questionId) {
        return userMapper.selectUserByQuestionId(questionId);
    }

    public UserQueryDTO selectUserByAnswerId(int answerId) {
        return userMapper.selectUserByAnswerId(answerId);
    }

    public UserDetails loadUserDetailsByLoginId(String loginId) throws UsernameNotFoundException {
        UserQueryDTO loginUser = userMapper.selectUserByLoginId(loginId);

        if(loginUser == null) {
            throw new UsernameNotFoundException(loginId + "라는 id가 존재하지 않습니다.");
        }

        return new User(loginUser.getLoginId(), loginUser.getPassword(),
                true, true, true, true, new ArrayList<>());
    }
}
