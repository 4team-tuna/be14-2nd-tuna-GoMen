package com.tuna.gomen.mentorList.query.service;

import com.tuna.gomen.mentorList.query.dto.MentorListDTO;

import java.util.List;

public interface MentorListService {
    List<MentorListDTO> findAllActiveMentors();

}
