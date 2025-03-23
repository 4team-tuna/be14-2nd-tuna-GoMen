package com.tuna.gomen.user.service;

import com.tuna.gomen.mapper.UserMapper;
import com.tuna.gomen.user.command.entity.UserEntity;
import com.tuna.gomen.user.dto.UserDTO;
import com.tuna.gomen.user.repository.UserRepository;
import com.tuna.gomen.user.vo.RequestQuitVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository, ModelMapper modelMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(loginUser.getLoginId(), loginUser.getPassword(),
                true, true, true, true, grantedAuthorities);
    }

    @Transactional
    public void registUser(UserDTO userDTO) {
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        userRepository.save(user);
    }

    @Transactional
    public void quitUser(RequestQuitVO quitVO) {
        UserDTO userDTO = selectUserByLoginId(quitVO.getLoginId());
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setIsQuitted("Y");
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(RequestQuitVO quitVO) {
        UserDTO userDTO = selectUserByLoginId(quitVO.getLoginId());
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        userRepository.delete(user);
    }
}
