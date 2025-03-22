package com.tuna.gomen.mentoringspace.command.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_mentoring_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MentoringSpaceMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentoring_space_member_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoring_space_id", nullable = false)
    private MentoringSpace mentoringSpace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User mentee;

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

}
