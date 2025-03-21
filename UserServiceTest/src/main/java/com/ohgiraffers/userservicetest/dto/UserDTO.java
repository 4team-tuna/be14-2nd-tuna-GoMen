package com.ohgiraffers.userservicetest.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_test")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;                    // 회원번호

    @Column(name="login_id", nullable=false, length=50, unique=true)
    private String loginId;               // 회원의 이메일(ID 개념)

    @Column(name="password", nullable=false)
    private String password;              // 회원 가입 이후 자동으로 발생 할 고유 번호(일종의 닉네임)
}
