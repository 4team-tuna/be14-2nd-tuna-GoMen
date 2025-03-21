package com.ohgiraffers.userservicetest.service;

import com.ohgiraffers.userservicetest.dto.UserDTO;
import com.ohgiraffers.userservicetest.repository.UserMapper;
import com.ohgiraffers.userservicetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public void registUser(UserDTO userDTO) {
        List<UserDTO> users = userMapper.selectAllUsers();
//        int lastNumber = users.size()-1;
//        userDTO.setUserId(lastNumber);
        userRepository.save(userDTO);
    }
}
