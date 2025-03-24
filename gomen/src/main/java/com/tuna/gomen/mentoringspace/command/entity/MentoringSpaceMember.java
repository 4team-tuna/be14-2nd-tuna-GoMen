package com.tuna.gomen.mentoringspace.command.entity;

import com.tuna.gomen.user.command.entity.User;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoring_space_id")
    private MentoringSpace mentoringSpaceId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "leftover_questions", nullable = false)
    private Integer leftoverQuestion = 10;

    @Override
    public String toString() {
        return "MentoringSpaceMember{" +
                ", leftoverQuestion=" + leftoverQuestion +
                '}';
    }

}
