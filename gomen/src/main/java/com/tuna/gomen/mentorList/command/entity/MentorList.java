package com.tuna.gomen.mentorList.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_mentor_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorList {

    @Id
    @Column(name = "mentor_id")
    private Integer mentorId;

    @Column(name = "m_expert")
    private String MExpert;

    @Column(name = "m_content")
    private String MContent;

    @Column(name = "is_deleted")
    private String isDeleted = "N";
}
