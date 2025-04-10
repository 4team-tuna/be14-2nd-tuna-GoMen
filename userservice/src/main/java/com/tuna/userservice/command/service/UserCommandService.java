package com.tuna.userservice.command.service;

import com.tuna.userservice.query.dto.UserQueryDTO;
import com.tuna.userservice.query.mapper.UserMapper;
import com.tuna.userservice.command.entity.UserEntity;
import com.tuna.userservice.command.dto.UserCommandDTO;
import com.tuna.userservice.command.repository.UserRepository;
import com.tuna.userservice.query.service.UserQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCommandService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserQueryService userQueryService;

    @Autowired
    public UserCommandService(UserMapper userMapper, UserRepository userRepository, ModelMapper modelMapper, UserQueryService userQueryService) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userQueryService = userQueryService;
    }

    @Transactional
    public void registUser(UserCommandDTO userCommandDTO) {
        UserEntity user = modelMapper.map(userCommandDTO, UserEntity.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Transactional
    public void quitUser(String loginId) {
        UserQueryDTO userQueryDTO = userQueryService.selectUserByLoginId(loginId);
        UserEntity user = modelMapper.map(userQueryDTO, UserEntity.class);
        if(user.getIsQuitted().equals("N")) {
            user.setIsQuitted("Y");
        } else {
            throw new RuntimeException();
        }
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String loginId) {
        UserQueryDTO userQueryDTO = userQueryService.selectUserByLoginId(loginId);
        UserEntity user = modelMapper.map(userQueryDTO, UserEntity.class);
        userRepository.delete(user);
    }

    @Transactional
    public void changeToMentor(String loginId) {
        UserQueryDTO userQueryDTO = userQueryService.selectUserByLoginId(loginId);
        UserEntity user = modelMapper.map(userQueryDTO, UserEntity.class);
        if(user.getIsMentor().equals("N")) {
            user.setIsMentor("Y");
        } else {
            throw new RuntimeException();
        }
        userRepository.save(user);
    }

    @Transactional
    public void changePassword(String loginId, String password) {
        UserQueryDTO userQueryDTO = userQueryService.selectUserByLoginId(loginId);
        UserEntity user = modelMapper.map(userQueryDTO, UserEntity.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    @Transactional
    public void changeCollege(String loginId, String college) {
        UserQueryDTO userQueryDTO = userQueryService.selectUserByLoginId(loginId);
        UserEntity user = modelMapper.map(userQueryDTO, UserEntity.class);
        user.setCollege(college);
        userRepository.save(user);
    }

    @Transactional
    public void changeBlog(String loginId, String blog) {
        UserQueryDTO userQueryDTO = userQueryService.selectUserByLoginId(loginId);
        UserEntity user = modelMapper.map(userQueryDTO, UserEntity.class);
        user.setBlog(blog);
        userRepository.save(user);
    }
}
