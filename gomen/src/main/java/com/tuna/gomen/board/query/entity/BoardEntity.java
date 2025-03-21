package com.tuna.gomen.board.query.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BoardEntity {
    private Long postId;
    private String category;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String isBlinded;
    private String isDeleted;
    private Long userId;

    // 파일 주소 리스트 추가
    private List<String> fileAddresses;  // 파일 주소들을 담을 리스트
}