package com.tuna.gomen.mentoringspace.command.service;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentoringSpaceService {

    private final MentoringSpaceRepository mentoringSpaceRepository;

    @Autowired
    public MentoringSpaceService(MentoringSpaceRepository mentoringSpaceRepository) {
        this.mentoringSpaceRepository = mentoringSpaceRepository;
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
}
