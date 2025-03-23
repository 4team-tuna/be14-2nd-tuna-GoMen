package com.tuna.gomen.mentorList.command;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_mentor_list")
public class MentorList {

    @Id
    @Column(name = "mentor_id")
    private Integer mentorId;


}
