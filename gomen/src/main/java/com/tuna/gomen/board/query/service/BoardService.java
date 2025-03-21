package com.tuna.gomen.board.query.service;

import com.tuna.gomen.board.query.entity.BoardEntity;
import com.tuna.gomen.board.query.entity.UserEntity;
import com.tuna.gomen.board.query.dto.BoardDto;
import com.tuna.gomen.board.query.dto.CommentDto;
import com.tuna.gomen.board.query.dto.UserDto;
import com.tuna.gomen.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 기존 전체 조회
    public List<BoardDto> getAllBoardDtos() {
        return boardMapper.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 한 게시물 조회
    public BoardDto getBoardDetails(int postId) {
        BoardEntity boardEntity = boardMapper.getBoardDetails(postId);
        if (boardEntity == null) {
            return null;  // 게시물이 없을 경우 null 반환
        }
//        System.out.println("fileAddresses: " + boardEntity.getFileAddresses()); // 여기서 문제확인
        return convertToDto(boardEntity);  // 엔티티를 DTO로 변환하여 반환
    }


    // 특정 사용자의 게시글 조회
    public List<BoardDto> getBoardsByUserId(Long userId) {
        return boardMapper.findByUserId(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 카테고리의 게시글 조회
    public List<BoardDto> getBoardsByCategory(String category) {
        return boardMapper.findByCategory(category).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 키워드가 포함된 제목의 게시글 조회
    public List<BoardDto> getBoardsByTitleKeyword(String keyword) {
        return boardMapper.findByTitleKeyword(keyword).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }



    // Entity -> DTO 변환 메서드
    private BoardDto convertToDto(BoardEntity entity) {
        BoardDto dto = new BoardDto();
        dto.setPostId(entity.getPostId());
        dto.setCategory(entity.getCategory());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setModifiedAt(entity.getModifiedAt());
        dto.setIsBlinded(entity.getIsBlinded());
        dto.setIsDeleted(entity.getIsDeleted());
        dto.setUserId(entity.getUserId());
        dto.setFileAddresses(entity.getFileAddresses());
        return dto;
    }

    // 특정 게시글의 작성자 정보 조회
    public UserDto getAuthorByPostId(Long postId) {
        UserEntity user = boardMapper.findAuthorByPostId(postId);
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setLoginId(user.getLoginId());
        dto.setName(user.getName());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setNickname(user.getNickname());
        dto.setCareerInfo(user.getCareerInfo());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    // 특정 게시글의 댓글 조회
    public List<CommentDto> getCommentsByPostId(Long postId) {
        return boardMapper.findCommentsByPostId(postId).stream().map(comment -> {
            CommentDto dto = new CommentDto();
            dto.setCommentId(comment.getCommentId());
            dto.setCommentContent(comment.getCommentContent());
            dto.setCreatedAt(comment.getCreatedAt());
            dto.setUserId(comment.getUserId());
            dto.setUserNickname(comment.getUserId() != null ? boardMapper.findAuthorByPostId(comment.getUserId()).getNickname() : "익명");
            return dto;
        }).collect(Collectors.toList());
    }
}
