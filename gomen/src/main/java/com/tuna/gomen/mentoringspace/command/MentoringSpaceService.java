package com.tuna.gomen.mentoringspace.command;

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
}
