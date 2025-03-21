//package com.ohgiraffers.tuna;
//
//import com.ohgiraffers.tuna.entity.Member;
//import com.ohgiraffers.tuna.mapper.MemberMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class MemberMapperTest {
//
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @Test
//    void testFindAllMembers() {
//        List<Member> members = memberMapper.findAll();
//        assertNotNull(members, "조회된 회원 목록이 null이면 안 됩니다.");
//        assertFalse(members.isEmpty(), "회원 목록이 비어 있으면 안 됩니다.");
//    }
//
//    @Test
//    void testFindMemberById() {
//        Long testId = 1L; // 테스트할 user_id
//        com.ohgiraffers.tuna.entity.Member member = memberMapper.findById(testId);
//        assertNotNull(member, "해당 ID의 회원이 존재해야 합니다.");
//        assertEquals(testId, member.getUserId(), "조회된 회원 ID가 요청한 ID와 일치해야 합니다.");
//    }
//}
