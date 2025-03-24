package com.tuna.gomen.mentorList.command.service;

import com.tuna.gomen.mentorList.command.dto.MentorListRequest;
import com.tuna.gomen.mentorList.command.dto.MentorListResponse;
import com.tuna.gomen.mentorList.command.entity.MentorList;
import com.tuna.gomen.mentorList.command.repository.MentorListRepository;

import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentorListService {

    private final MentorListRepository mentorListRepository;
    private final UserRepository userRepository;

    @Autowired
    public MentorListService(MentorListRepository mentorListRepository, UserRepository userRepository) {
        this.mentorListRepository = mentorListRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public MentorListResponse addMentor(MentorListRequest request) {
        if (mentorListRepository.existsByMentorId(request.getMentorId())) {
            throw new IllegalArgumentException("이미 멘토로 등록된 사용자입니다.");
        }

        User user = userRepository.findById(request.getMentorId())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        if (!"Y".equals(user.getIsMentor())) {
            throw new IllegalArgumentException("해당 사용자는 멘토 자격이 없습니다.");
        }

        MentorList entry = new MentorList();
        entry.setMentorId(request.getMentorId());
        entry.setMExpert(request.getMexpert());
        entry.setMContent(request.getMcontent());
        entry.setIsDeleted("N");

        mentorListRepository.save(entry);

        return new MentorListResponse(entry.getMentorId(), entry.getMExpert(), entry.getMContent(), entry.getIsDeleted());
    }

    @Transactional
    public void removeMentor(Integer mentorId) {
        MentorList entry = mentorListRepository.findById(mentorId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멘토가 존재하지 않습니다."));

        entry.setIsDeleted("Y");
        mentorListRepository.save(entry);
    }
}
