package com.tuna.gomen.mentoringBoard.command.entity;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.user.command.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "tbl_answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;

    @Column(name = "answer_content")
    private String answerContent;

    @Column(name = "answer_created_time")
    private LocalDateTime answerCreatedTime;

    @Column(name = "is_deleted")
    private String isDeleted = "N";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question questionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_member_id")
    private UserEntity answerMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_answer_id")
    private Answer refAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoring_space_id")
    private MentoringSpace mentoringSpaceId;

}
