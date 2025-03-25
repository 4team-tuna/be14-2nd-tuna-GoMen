package com.tuna.gomen.mentoringBoard.command.entity;

import com.tuna.gomen.file.entity.MentoringFile;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    private User answerMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_answer_id")
    private Answer refAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoring_space_id")
    private MentoringSpace mentoringSpaceId;

    @OneToMany(mappedBy = "answerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MentoringFile> files = new ArrayList<>();

}
