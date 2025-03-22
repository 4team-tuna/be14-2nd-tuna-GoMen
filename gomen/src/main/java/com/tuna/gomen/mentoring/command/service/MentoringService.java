package com.tuna.gomen.mentoring.command.service;

import com.tuna.gomen.mentorList.command.repository.MentorListRepository;
import com.tuna.gomen.mentoring.command.dto.MentoringAcceptRequest;
import com.tuna.gomen.mentoring.command.dto.MentoringRequest;
import com.tuna.gomen.mentoring.command.entity.MentoringRequestPK;
import com.tuna.gomen.mentoring.command.entity.Mentoring;
import com.tuna.gomen.mentoring.command.repository.MentoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final MentorListRepository mentorListRepository;

    @Autowired
    public MentoringService(MentoringRepository mentoringRepository, MentorListRepository mentorListRepository) {
        this.mentoringRepository = mentoringRepository;
        this.mentorListRepository = mentorListRepository;
    }

    @Transactional
    public Mentoring applyMentoring(MentoringRequest request) {

        boolean mentorExists = mentorListRepository.existsById(request.getMentorId());
        if (!mentorExists) {
            throw new IllegalArgumentException("존재하지 않는 멘토 ID입니다.");
        }

        Mentoring mentoring = new Mentoring();
        mentoring.setMentorId(request.getMentorId());
        mentoring.setMenteeId(request.getMenteeId());
        mentoring.setTeamId(request.getTeamId());
        mentoring.setIsAccepted("N");

        return mentoringRepository.save(mentoring);
    }

    @Transactional
    public Mentoring acceptMentoring(MentoringAcceptRequest request) {

        MentoringRequestPK id = new MentoringRequestPK(
                request.getMentorId(),
                request.getMenteeId(),
                request.getTeamId()
        );

        Mentoring mentoring = mentoringRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토링 신청을 찾을 수 없습니다."));

        mentoring.setIsAccepted(request.getIsAccepted());

        return mentoringRepository.save(mentoring);

    }
}
