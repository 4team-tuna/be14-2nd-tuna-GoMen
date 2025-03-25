package com.tuna.gomen.teamRecruitBoard.service;

import com.tuna.gomen.teamRecruitBoard.entity.TeamRecruitBoard;
import com.tuna.gomen.teamRecruitBoard.repository.TeamRecruitBoardRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TeamRecruitBoardServiceImplTest {

    @Mock
    private TeamRecruitBoardRepository teamRecruitBoardRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TeamRecruitBoardServiceImpl teamRecruitBoardServiceImpl;

    private User leader;
    private TeamRecruitBoard teamRecruitBoard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        leader = new User();
        leader.setUserId(1);  // 리더 ID 설정

        teamRecruitBoard = new TeamRecruitBoard();
        teamRecruitBoard.setTeamPostId(1);
        teamRecruitBoard.setPostTitle("Test Title");
        teamRecruitBoard.setTeamName("Test Team");
        teamRecruitBoard.setTeamIntroduce("Test Introduction");
        teamRecruitBoard.setLeader(leader);
    }

    @Test
    void 팀_모집_게시글_삭제_테스트() {
        // Given
        when(teamRecruitBoardRepository.findById(1)).thenReturn(Optional.of(teamRecruitBoard));

        // When
        teamRecruitBoardServiceImpl.deleteTeamRecruit(1, 1);

        // Then
        assertEquals("Y", teamRecruitBoard.getIsDeleted());
        verify(teamRecruitBoardRepository, times(1)).save(teamRecruitBoard);  // save가 한 번 호출되었는지 확인
    }

    @Test
    void 게시글_삭제_권한_테스트() {
        // Given
        User nonLeader = new User();
        nonLeader.setUserId(2);  // 리더가 아닌 사용자

        when(teamRecruitBoardRepository.findById(1)).thenReturn(Optional.of(teamRecruitBoard));

        // When and Then
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            teamRecruitBoardServiceImpl.deleteTeamRecruit(1, 2);  // 리더가 아닌 사용자로 삭제 시도
        });

        assertEquals("삭제 권한이 없습니다.", exception.getMessage());
    }

    @Test
    void 존재하지_않는_게시글_삭제_테스트() {
        // Given
        when(teamRecruitBoardRepository.findById(1)).thenReturn(Optional.empty());

        // When and Then
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            teamRecruitBoardServiceImpl.deleteTeamRecruit(1, 1);  // 존재하지 않는 게시글을 삭제 시도
        });

        assertEquals("팀 모집 글이 존재하지 않습니다.", exception.getMessage());
    }
}
