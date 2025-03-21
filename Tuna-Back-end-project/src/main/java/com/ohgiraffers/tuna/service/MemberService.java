package com.ohgiraffers.tuna.service;

import com.ohgiraffers.tuna.entity.Member;
import com.ohgiraffers.tuna.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Member getMemberById(Integer id) {
        return memberMapper.findById(id);
    }

    public List<Member> getAllMembers() {
        return memberMapper.findAll();
    }
}

