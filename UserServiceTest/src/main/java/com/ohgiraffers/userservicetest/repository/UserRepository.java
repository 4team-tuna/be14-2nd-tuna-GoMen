package com.ohgiraffers.userservicetest.repository;

import com.ohgiraffers.userservicetest.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {
}
