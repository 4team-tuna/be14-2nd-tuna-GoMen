package com.tuna.gomen.mentorList.service;

import com.tuna.gomen.mapper.MentorListMapper;
import com.tuna.gomen.mentorList.domain.entity.MentorList;
import com.tuna.gomen.mentorList.dto.MentorListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorListServiceImpl implements MentorListService {

    private final MentorListMapper mentorListMapper;

    public MentorListServiceImpl(MentorListMapper mentorListMapper) {
        this.mentorListMapper = mentorListMapper;
    }

    @Override
    public List<MentorListDTO> findAllActiveMentors() {
        List<MentorList> mentorLists = mentorListMapper.findAllActiveMentors();

        return mentorLists.stream()
                .map(mentor -> new MentorListDTO(
                        mentor.getMentorId(),
                        mentor.getMExpert(),
                        mentor.getMContent(),
                        mentor.getIsDeleted()
                ))
                .collect(Collectors.toList());
    }
}
