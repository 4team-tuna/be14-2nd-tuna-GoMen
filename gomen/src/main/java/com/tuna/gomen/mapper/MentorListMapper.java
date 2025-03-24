package com.tuna.gomen.mapper;

import com.tuna.gomen.mentorList.query.domain.entity.MentorList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MentorListMapper {
    List<MentorList> findAllActiveMentors();



}
