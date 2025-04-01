package com.tuna.userservice.security;

import com.tuna.userservice.command.dto.UserCommandDTO;
import com.tuna.userservice.query.dto.UserQueryDTO;
import com.tuna.userservice.query.service.UserQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private UserQueryService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public JwtAuthenticationProvider(UserQueryService userCommandService, PasswordEncoder passwordEncoder) {
        this.userService = userCommandService;
        this.passwordEncoder = passwordEncoder;
    }

    /* 설명. Token에서 id, pwd, 권한을 가져와서 UserDetails를 담은 토큰 생성 */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginId = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userService.loadUserDetailsByLoginId(loginId);

        if(!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        UserQueryDTO userQueryDTO = userService.selectUserByLoginId(loginId);
        String loginIdAndUserId = loginId + "@" + userQueryDTO.getUserId();
        userDetails = new User(loginIdAndUserId, password,
                true, true, true, true, new ArrayList<>());
        if(userQueryDTO.getIsQuitted().equals("Y")){
            throw new RuntimeException("탈퇴한 회원입니다.");
        } else {
            /* 설명. 비밀번호 일치 시에 token발행 */
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, authentication.getAuthorities());
            return authenticationToken;
        }
    }

    /* 설명. UsernamePasswordAuthenticationToken이 생성 시에 이 프로바이더를 인식하도록 설정 */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
