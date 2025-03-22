package com.tuna.gomen.mentoringspace.command;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_mentoring_sapce")
public class MentoringSpace {

    @Id
    @Column(name = "mentoring_space_id")
    private Integer mentoringSpaceId;

    @Column(name = "personal_information", nullable = false)
    private String personalInformation;

    @Column(name = "information_is_opened", nullable = false)
    private String informationIsOpened;

    @Column(name = "extension_count", nullable = false)
    private Integer extensionCount;

    @Column(name = "is_activated", nullable = false)
    private String isActivated;

    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
