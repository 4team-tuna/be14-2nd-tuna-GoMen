package com.tuna.gomen.user.repository;

<<<<<<< HEAD
import com.tuna.gomen.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
=======

import com.tuna.gomen.user.command.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 추가적인 메소드 구현이 필요하다면 여기에 추가
>>>>>>> d64258bbdfba9da895ffde5c347327bf1a8d3abc
}
