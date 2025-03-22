package com.tuna.gomen.mentoringspace.command.service;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.entity.User;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceMemberRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.mentoringspace.command.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class MentoringSpaceMemberService {

    private final MentoringSpaceMemberRepository mentoringSpaceMemberRepository;
    private final MentoringSpaceRepository mentoringSpaceRepository;
    private final UserRepository userRepository;

    @Autowired
    public MentoringSpaceMemberService(MentoringSpaceMemberRepository mentoringSpaceMemberRepository,
                                       MentoringSpaceRepository mentoringSpaceRepository,
                                       UserRepository userRepository) {
        this.mentoringSpaceMemberRepository = mentoringSpaceMemberRepository;
        this.mentoringSpaceRepository = mentoringSpaceRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public MentoringSpaceMember registerMember(Integer mentoringSpaceId, Integer userId) {
//        if (mentoringSpaceMemberRepository.existsByMentoringSpace_MentoringSpaceIdAndMentee_UserId(mentoringSpaceId, userId)) {
//            throw new IllegalArgumentException("이미 등록된 멤버입니다.");
//        }

        MentoringSpace space = mentoringSpaceRepository.findById(mentoringSpaceId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멘토링 공간입니다."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        MentoringSpaceMember member = new MentoringSpaceMember();
        member.setMentoringSpace(space);
        member.setMentee(user);
        member.setJoinedAt(LocalDateTime.now());

        return mentoringSpaceMemberRepository.save(member);
    }
}
