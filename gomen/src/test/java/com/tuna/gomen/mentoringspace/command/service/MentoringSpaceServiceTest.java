package com.tuna.gomen.mentoringspace.command.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.tuna.gomen.mentoringspace.command.entity.MentoringSpace;
import com.tuna.gomen.mentoringspace.command.entity.MentoringSpaceMember;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceMemberRepository;
import com.tuna.gomen.mentoringspace.command.repository.MentoringSpaceRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class MentoringSpaceServiceTest {

    @Autowired
    private MentoringSpaceService mentoringSpaceService;

    @MockBean
    private MentoringSpaceRepository mentoringSpaceRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private MentoringSpaceMemberRepository mentoringSpaceMemberRepository;

    @Test
    @DisplayName("멘토링 연장 요청 테스트")
    void requestExtensionTest() {
        // Given
        Integer spaceId = 31;
        Integer userId = 11;
        MentoringSpace space = new MentoringSpace();
        space.setExtensionRequested("N");

        User user = new User();
        MentoringSpaceMember member = new MentoringSpaceMember();
        member.setLeftoverQuestion(0);

        when(mentoringSpaceRepository.findById(spaceId)).thenReturn(Optional.of(space));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(mentoringSpaceMemberRepository.findByMentoringSpaceIdAndUserId(space, user))
                .thenReturn(Optional.of(member));

        // When
        mentoringSpaceService.requestExtension(spaceId, userId);

        // Then
        assertEquals("Y", space.getExtensionRequested());
    }

    @Test
    @DisplayName("멘토링 연장 요청 승인 테스트")
    void approveExtensionTest() {
        // Given
        Integer spaceId = 31;
        MentoringSpace space = new MentoringSpace();
        space.setExtensionRequested("Y");
        space.setExtensionCount(0);

        MentoringSpaceMember member = new MentoringSpaceMember();
        member.setLeftoverQuestion(0);

        when(mentoringSpaceRepository.findById(spaceId)).thenReturn(Optional.of(space));
        when(mentoringSpaceMemberRepository.findByMentoringSpaceId_MentoringSpaceId(spaceId)).thenReturn(member);

        // When
        mentoringSpaceService.approveExtension(spaceId);

        // Then
        assertEquals(1, space.getExtensionCount());
        assertEquals(10, member.getLeftoverQuestion());
        assertEquals("N", space.getExtensionRequested());
    }

    @Test
    @DisplayName("멘토링 연장 요청 거절 테스트")
    void rejectExtensionTest() {
        // Given
        Integer spaceId = 31;
        MentoringSpace space = new MentoringSpace();
        space.setExtensionRequested("Y");

        when(mentoringSpaceRepository.findById(spaceId)).thenReturn(Optional.of(space));

        // When
        mentoringSpaceService.rejectExtension(spaceId);

        // Then
        assertEquals("N", space.getIsActivated());
    }
}