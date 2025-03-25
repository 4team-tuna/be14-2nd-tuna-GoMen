package com.tuna.gomen.mentorList.command.repository;

import com.tuna.gomen.mentorList.command.entity.MentorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorListRepository extends JpaRepository<MentorList, Integer> {
    boolean existsByMentorId(Integer mentorId);
}
