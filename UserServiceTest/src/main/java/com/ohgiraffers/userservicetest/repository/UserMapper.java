package com.ohgiraffers.userservicetest.repository;

import com.ohgiraffers.userservicetest.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
     List<UserDTO> selectAllUsers();
}
