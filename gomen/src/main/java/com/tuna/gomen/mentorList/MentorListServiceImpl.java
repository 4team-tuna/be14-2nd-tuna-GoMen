package com.tuna.gomen.mentorList;

import com.tuna.gomen.mapper.MentorListMapper;
import com.tuna.gomen.mentoring.MentoringService;
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
