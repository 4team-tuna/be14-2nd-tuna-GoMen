package com.tuna.gomen.mentorList.command.repository;

import com.tuna.gomen.mentorList.command.entity.MentorList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorListRepository extends JpaRepository<MentorList, Integer> {
}
