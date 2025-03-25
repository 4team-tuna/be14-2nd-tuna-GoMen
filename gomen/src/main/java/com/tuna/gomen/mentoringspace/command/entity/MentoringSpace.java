package com.tuna.gomen.mentoringspace.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_mentoring_space")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MentoringSpace {

    @Id
    @Column(name = "mentoring_space_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentoringSpaceId;

    @Column(name = "personal_information", nullable = false)
    private String personalInformation = "";

    @Column(name = "personal_info_requested", nullable = false)
    private String personalInfoRequested = "N";

    @Column(name = "information_is_opened", nullable = false)
    private String informationIsOpened = "N";

    @Column(name = "extension_count", nullable = false)
    private Integer extensionCount = 0;

    @Column(name = "extension_requested")
    private String extensionRequested = "N";

    @Column(name = "is_activated", nullable = false)
    private String isActivated = "Y";

    @Column(name = "mentor_id", nullable = false)
    private Integer mentorId;
}
