package com.tuna.gomen.title.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tuna.gomen.title.entity.Title;
import com.tuna.gomen.title.entity.TitleList;
import com.tuna.gomen.title.repository.TitleListRepository;
import com.tuna.gomen.title.repository.TitleRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.Optional;

class TitleListServiceTest {

    @Mock
    private TitleListRepository titleListRepository;

    @Mock
    private TitleRepository titleRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TitleListServiceImpl titleListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 존재하는_칭호를_존재하는_회원에게_부여_테스트() {
        // given
        Integer userId = 1;
        Integer titleId = 100;

        User mockUser = new User();
        mockUser.setUserId(userId);

        Title mockTitle = new Title();
        mockTitle.setTitleId(titleId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(titleRepository.findById(titleId)).thenReturn(Optional.of(mockTitle));
        when(titleListRepository.existsByUserIdAndTitleId(userId, titleId)).thenReturn(false);

        // when
        assertDoesNotThrow(() -> titleListService.addTitleToUser(userId, titleId));

        // then
        verify(titleListRepository, times(1)).save(any(TitleList.class));
    }

    @Test
    void 존재하는_칭호를_존재하지_않는_회원에게_부여_테스트() {
        // given
        Integer userId = 1;
        Integer titleId = 100;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // when & then
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> titleListService.addTitleToUser(userId, titleId));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void 존재하지_않는_칭호를_존재하는_회원에게_부여_테스트() {
        // given
        Integer userId = 1;
        Integer titleId = 100;

        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));
        when(titleRepository.findById(titleId)).thenReturn(Optional.empty());

        // when & then
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> titleListService.addTitleToUser(userId, titleId));

        assertEquals("Title not found", exception.getMessage());
    }

    @Test
    void 이미_부여된_칭호를_부여_테스트() {
        // given
        Integer userId = 1;
        Integer titleId = 100;

        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));
        when(titleRepository.findById(titleId)).thenReturn(Optional.of(new Title()));
        when(titleListRepository.existsByUserIdAndTitleId(userId, titleId)).thenReturn(true);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> titleListService.addTitleToUser(userId, titleId));

        assertEquals("Title already assigned to the user.", exception.getMessage());
    }

    @Test
    void 고의적으로_예외를_발생시켜_DB_저장에_실패하는_테스트() {
        // given
        Integer userId = 1;
        Integer titleId = 100;

        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));
        when(titleRepository.findById(titleId)).thenReturn(Optional.of(new Title()));
        when(titleListRepository.existsByUserIdAndTitleId(userId, titleId)).thenReturn(false);
        when(titleListRepository.save(any(TitleList.class))).thenThrow(new DataIntegrityViolationException("DB error"));

        // when & then
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> titleListService.addTitleToUser(userId, titleId));

        assertEquals("Failed to assign title to user", exception.getMessage());
    }
}
