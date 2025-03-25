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
@Table(name = "tbl_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "question_content", nullable = false)
    private String questionContent;

    @Column(name = "question_created_time")
    private LocalDateTime questionCreatedTime = LocalDateTime.now();

    @Column(name = "is_deleted")
    private String isDeleted = "N";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private User MemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoring_space_id", nullable = false)
    private MentoringSpace mentoringSpaceId;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MentoringFile> files = new ArrayList<>();

}
