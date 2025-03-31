package com.tuna.gomen.teamRecruitBoard.command.entity;

import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_team_recruit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamRecruitBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_post_id")
    private Integer teamPostId;  // 팀 게시글 ID

    @Column(name = "post_title", nullable = false)
    private String postTitle;  // 게시글 제목

    @Column(name = "team_name", nullable = false)
    private String teamName;  // 팀 이름

    @Column(name = "team_introduce", nullable = false)
    private String teamIntroduce;  // 팀 소개

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME DEFAULT NOW()")
    private LocalDateTime createdAt = LocalDateTime.now();  // 게시글 생성 시간

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;  // 게시글 수정 시간 (수정된 경우에만 값 있음)

    @Column(name = "is_deleted", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'N'")
    private String isDeleted = "N";  // 삭제 여부 (기본값 'N')

    @Column(name = "is_completed", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'N'")
    private String isCompleted = "N";  // 완료 여부 (기본값 'N')

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id", nullable = false)
    private User leader;  // 팀 리더 (tbl_user와 외래키 관계)

}
