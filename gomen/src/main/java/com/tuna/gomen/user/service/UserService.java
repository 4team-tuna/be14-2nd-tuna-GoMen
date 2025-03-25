package com.tuna.gomen.user.service;

import com.tuna.gomen.mapper.UserMapper;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.dto.UserDTO;
import com.tuna.gomen.user.vo.RequestQuitVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserMapper userMapper, ModelMapper modelMapper, UserRepository userRepository)
    {
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
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

    public UserDetails loadUserDetailsByLoginId(String loginId) throws UsernameNotFoundException {
        UserDTO loginUser = userMapper.selectUserByLoginId(loginId);

        if(loginUser == null) {
            throw new UsernameNotFoundException(loginId + "라는 id가 존재하지 않습니다.");
        }

        return new org.springframework.security.core.userdetails.User(loginUser.getLoginId(), loginUser.getPassword(),
                true, true, true, true, new ArrayList<>());
    }

    @Transactional
    public void registUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Transactional
    public void quitUser(RequestQuitVO quitVO) {
        UserDTO userDTO = selectUserByLoginId(quitVO.getLoginId());
        User user = modelMapper.map(userDTO, User.class);
        user.setIsQuitted("Y");
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(RequestQuitVO quitVO) {
        UserDTO userDTO = selectUserByLoginId(quitVO.getLoginId());
        User user = modelMapper.map(userDTO, User.class);
        userRepository.delete(user);
    }
}
