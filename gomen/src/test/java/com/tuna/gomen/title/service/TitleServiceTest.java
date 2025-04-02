package com.tuna.gomen.title.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tuna.gomen.title.entity.Title;
import com.tuna.gomen.title.repository.TitleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TitleServiceTest {

    @Mock
    private TitleRepository titleRepository;

    @InjectMocks
    private TitleServiceImpl titleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 정상적인_칭호_생성_테스트() {

        // Given
        String titleName = "God of Extension";
        when(titleRepository.existsByTitleName(titleName)).thenReturn(false);
        when(titleRepository.save(any(Title.class))).thenAnswer(invocation -> invocation.getArgument(0)); // 저장 시 그대로 반환

        // when
        Title createdTitle = titleService.createTitle(titleName);

        // Then
        assertNotNull(createdTitle);
        assertEquals(titleName, createdTitle.getTitleName());
    }

    @Test
    void 칭호_생성시_중복_에러_상황_테스트() {

        // Given
        String titleName = "God of Extension";
        when(titleRepository.existsByTitleName(titleName)).thenReturn(true); // 중복 O

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            titleService.createTitle(titleName);
        });

        assertEquals("이미 존재하는 칭호입니다.", exception.getMessage());

    }
}