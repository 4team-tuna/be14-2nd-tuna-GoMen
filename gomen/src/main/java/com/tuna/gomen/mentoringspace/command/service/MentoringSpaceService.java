package com.tuna.gomen.mentoringspace.command.service;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceMemberRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MentoringSpaceService {

    private final MentoringSpaceRepository mentoringSpaceRepository;
    private final MentoringSpaceMemberRepository mentoringSpaceMemberRepository;
    private final UserRepository userRepository;


    @Autowired
    public MentoringSpaceService(MentoringSpaceRepository mentoringSpaceRepository,
                                 MentoringSpaceMemberRepository mentoringSpaceMemberRepository, UserRepository userRepository) {
        this.mentoringSpaceRepository = mentoringSpaceRepository;
        this.mentoringSpaceMemberRepository = mentoringSpaceMemberRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public MentoringSpace createMentoringSpace(MentoringSpace request) {

        if (!"Y".equals(request.getIsActivated()) && !"N".equals(request.getIsActivated())) {
            throw new IllegalArgumentException("isActivated 값은 'Y' 또는 'N'만 가능합니다.");
        }

        return mentoringSpaceRepository.save(request);
    }

    @Transactional
    public MentoringSpace updateMentoringSpace(Integer mentoringSpaceId,MentoringSpace request) {

        MentoringSpace space = mentoringSpaceRepository.findByMentoringSpaceId(mentoringSpaceId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토링 공간이 존재하지 않습니다."));

        space.setPersonalInformation(request.getPersonalInformation());
        space.setInformationIsOpened(request.getInformationIsOpened());
        space.setExtensionCount(request.getExtensionCount());
        space.setIsActivated(request.getIsActivated());

        return mentoringSpaceRepository.save(space);
    }

    @Transactional
    public MentoringSpace updatePersonalInformation(Integer mentoringSpaceId, String personalInformation) {
        MentoringSpace space = mentoringSpaceRepository.findByMentoringSpaceId(mentoringSpaceId)
                .orElseThrow(() -> new IllegalArgumentException("멘토링 공간이 존재하지 않습니다."));

        space.setPersonalInformation(personalInformation);
        space.setInformationIsOpened("Y");

        return mentoringSpaceRepository.save(space);
    }

    @Transactional
    public void deactivateMentoringSpace(Integer mentoringSpaceId) {
        MentoringSpace space = mentoringSpaceRepository.findByMentoringSpaceId(mentoringSpaceId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토링 공간이 존재하지 않습니다."));

        space.setIsActivated("N");
    }

    @Transactional
    public void requestExtension(Integer spaceId, Integer userId) {

        MentoringSpace space = mentoringSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new EntityNotFoundException("멘토링 공간이 존재하지 않습니다."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자가 존재하지 않습니다."));

        MentoringSpaceMember member = mentoringSpaceMemberRepository
                .findByMentoringSpaceIdAndUserId(space, user)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토링 공간의 멤버가 아닙니다."));

        if (member.getLeftoverQuestion() > 0) {
            throw new IllegalStateException("남은 질문이 있어 연장 요청이 불가능합니다.");
        }

        if ("Y".equals(space.getExtensionRequested())) {
            throw new IllegalStateException("이미 연장 요청이 진행 중입니다.");
        }

        space.setExtensionRequested("Y");
    }

    @Transactional
    public void approveExtension(Integer spaceId) {
        MentoringSpace space = mentoringSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("멘토링 공간을 찾을 수 없습니다."));

        if (space.getExtensionRequested().equals("N")) {
            throw new RuntimeException("연장 요청이 없습니다.");
        }

        MentoringSpaceMember member = mentoringSpaceMemberRepository.findByMentoringSpaceId_MentoringSpaceId(spaceId);

        // 연장 수락 처리
        space.setExtensionCount(space.getExtensionCount() + 1);
        member.setLeftoverQuestion(member.getLeftoverQuestion() + 10);
        space.setExtensionRequested("N");

        mentoringSpaceMemberRepository.save(member);
        mentoringSpaceRepository.save(space);
    }

    @Transactional
    public void rejectExtension(Integer spaceId) {

        MentoringSpace space = mentoringSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("멘토링 공간을 찾을 수 없습니다."));

        if ("N".equals(space.getExtensionRequested())) {
            throw new RuntimeException("연장 요청이 없습니다.");
        }

        space.setIsActivated("N");

        mentoringSpaceRepository.save(space);
    }

    @Transactional
    public void requestPersonalInfo(Integer spaceId) {
        MentoringSpace space = mentoringSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("해당 멘토링 공간이 없습니다."));

        if ("Y".equals(space.getPersonalInfoRequested())) {
            throw new RuntimeException("이미 개인정보 공개 요청이 진행 중입니다.");
        }

        space.setPersonalInfoRequested("Y");
        mentoringSpaceRepository.save(space);
    }

    @Transactional
    public void approvePersonalInfoRequest(Integer mentoringSpaceId) {
        MentoringSpace space = mentoringSpaceRepository.findById(mentoringSpaceId)
                .orElseThrow(() -> new RuntimeException("멘토링 공간을 찾을 수 없습니다."));

        if ("N".equals(space.getPersonalInfoRequested())) {
            throw new IllegalStateException("개인정보 공개 요청이 없습니다.");
        }

        space.setInformationIsOpened("Y");

        mentoringSpaceRepository.save(space);
    }

}
