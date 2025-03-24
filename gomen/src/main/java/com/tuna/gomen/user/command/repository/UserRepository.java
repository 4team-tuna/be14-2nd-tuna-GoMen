package com.tuna.gomen.user.command.repository;

import com.tuna.gomen.user.command.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 추가적인 메소드 구현이 필요하다면 여기에 추가

}
