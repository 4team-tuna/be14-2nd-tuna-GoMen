package com.tuna.gomen.user.command.service;

import com.tuna.gomen.user.command.entity.UserEntity;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService2 {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getDefaultUser() {
        return userRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("User with ID 1 not found"));
    }

}
