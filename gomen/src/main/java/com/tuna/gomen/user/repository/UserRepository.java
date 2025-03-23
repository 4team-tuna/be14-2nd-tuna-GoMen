package com.tuna.gomen.user.repository;

import com.tuna.gomen.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
