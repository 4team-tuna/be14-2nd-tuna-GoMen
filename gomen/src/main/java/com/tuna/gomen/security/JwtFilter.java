package com.tuna.gomen.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");


        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);    // "Bearer를 제외
            log.info("순수 토큰 값 : {}", token);
            if(jwtUtil.validateToken(token)){

                /* 설명. Spring Security가 인식하도록 token에서 아이디와 권한을 추출 */
                Authentication authentication = jwtUtil.getAuthentication(token);

                /* 설명. Spring Security가 인식하도록 주입 */
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        /* 설명. 다음 필터를 진행하도록 해주는 구문 */
        filterChain.doFilter(request, response);
    }
}
