package com.tuna.gomen.mentoringspace.command;

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
