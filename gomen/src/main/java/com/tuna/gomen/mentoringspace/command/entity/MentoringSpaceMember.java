package com.tuna.gomen.mentoringspace.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_mentoring_member")
@IdClass(MentoringSpaceMemberPK.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoringSpaceMember {

    @Id
    @Column(name = "mentoring_space_id")
    private Integer mentoringSpace;

    @Id
    @Column(name = "user_id")
    private Integer mentee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoring_space_id", insertable = false, updatable = false)
    private MentoringSpace mentoringSpaceEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User userEntity;

    @Column(name = "leftover_questions", nullable = false)
    private Integer leftoverQuestion = 10;

    @Override
    public String toString() {
        return "MentoringSpaceMember{" +
                "mentoringSpace=" + mentoringSpace +
                ", mentee=" + mentee +
                ", leftoverQuestion=" + leftoverQuestion +
                '}';
    }

}
