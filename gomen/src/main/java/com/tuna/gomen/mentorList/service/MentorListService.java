package com.tuna.gomen.mentorList.service;

import com.tuna.gomen.mentorList.dto.MentorListDTO;

import java.util.List;

public interface MentorListService {
    List<MentorListDTO> findAllActiveMentors();

}
