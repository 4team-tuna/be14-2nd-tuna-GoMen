package com.ohgiraffers.tuna.mapper;

import com.ohgiraffers.tuna.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT user_id, login_id, password, name, personal_number, phone_number, nickname FROM tbl_user WHERE user_id = #{id}")
    Member findById(Integer id);

    @Select("SELECT user_id, login_id, password, name, personal_number, phone_number, nickname FROM tbl_user")
    List<Member> findAll();
}
