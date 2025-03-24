package com.tuna.gomen.mentoringspace.command.service;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceMemberRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public MentoringSpaceMember addMember(Integer mentoringSpaceId, Integer userId) {
        MentoringSpace space = mentoringSpaceRepository.findById(mentoringSpaceId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 멘토링 공간입니다."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        // 여기서 exists 확인
        if (mentoringSpaceMemberRepository.existsByMentoringSpaceIdAndUserId(space, user)) {
            throw new IllegalArgumentException("이미 등록된 멤버입니다.");
        }

        MentoringSpaceMember member = new MentoringSpaceMember();
        member.setMentoringSpaceId(space);
        member.setUserId(user);

        return mentoringSpaceMemberRepository.save(member);
    }
}
