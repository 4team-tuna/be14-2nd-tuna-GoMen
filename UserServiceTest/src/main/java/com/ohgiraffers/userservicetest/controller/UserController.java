package com.ohgiraffers.userservicetest.controller;

import com.ohgiraffers.userservicetest.dto.UserDTO;
import com.ohgiraffers.userservicetest.service.UserService;
import com.ohgiraffers.userservicetest.vo.RequestRegistUserVO;
import com.ohgiraffers.userservicetest.vo.ResponseRegistUserVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@Slf4j
public class UserController {
    private Environment env;
    private ModelMapper modelMapper;
    private UserService userService;

    @Autowired
    public UserController(Environment env, ModelMapper modelMapper, UserService userService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping("/user/regist")
    public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestRegistUserVO newUser) {
        UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);

        userService.registUser(userDTO);
        ResponseRegistUserVO registedUser = modelMapper.map(userDTO, ResponseRegistUserVO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(registedUser);
    }
}
