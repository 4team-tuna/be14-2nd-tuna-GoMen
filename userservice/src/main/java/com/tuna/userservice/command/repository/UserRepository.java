package com.tuna.userservice.command.repository;


import com.tuna.userservice.command.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // 추가적인 메소드 구현이 필요하다면 여기에 추가

}
