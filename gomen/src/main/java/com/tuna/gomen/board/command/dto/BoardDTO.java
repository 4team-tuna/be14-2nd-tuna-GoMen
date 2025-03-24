package com.tuna.gomen.board.command.dto;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.file.entity.BoardFile;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BoardDTO {
    private Integer postId;
    private String title;
    private String content;
    private Integer category;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private List<String> fileAddresses; // 🔥 파일 경로 리스트 추가

    public static BoardDTO fromEntity(Board board, List<BoardFile> files) {
        BoardDTO dto = new BoardDTO();
        dto.setPostId(board.getPostId());
        dto.setCategory(board.getCategory());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setCreatedAt(board.getCreatedAt());
        dto.setModifiedAt(board.getModifiedAt());

        // 📌 파일 정보를 DTO에 추가
        if (files != null) {
            List<String> fileAddresses = files.stream()
                    .map(BoardFile::getAddress)
                    .collect(Collectors.toList());
            dto.setFileAddresses(fileAddresses);
        }

        return dto;
    }
}
