package com.tuna.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuna.userservice.query.service.UserQueryService;
import com.tuna.userservice.command.vo.RequestLoginVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private Environment env;
    private UserQueryService userQueryService;


    public AuthenticationFilter(AuthenticationManager authenticatonManager, Environment env, UserQueryService userQueryService) {
        super(authenticatonManager);
        this.env = env;
        this.userQueryService = userQueryService;
    }

    /* 설명. 로그인 시도 시 동작하는 기능(POST / login 요청 시) */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {

            /* 설명. request를 통해 넘어온 json(login시 id/pwd)를 RequestLoginVO 옮겨 담기 */
            RequestLoginVO creds = new ObjectMapper().readValue(request.getInputStream(), RequestLoginVO.class);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if(creds.getLoginId().equals("ADMIN")){
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                    creds.getLoginId(),
                    creds.getPassword(),
                    authorities));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 설명. 로그인 성공 시 authentication Token 처리 */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        log.info("토큰에 들어있는 권한 : {}", authResult.getAuthorities());
        log.info("secret key: {}", env.getProperty("token.secret"));    // 토큰 생성에 필요한 secret key

        // loginId, 권한 목록, 만료 시간
        User user = (User) authResult.getPrincipal();   // UserDetails -> User (다운캐스팅)
        String loginId = user.getUsername().split("@")[0];
        String userId = user.getUsername().split("@")[1];

        List<String> roles = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        int expiration_time = env.getProperty("token.expiration_time", Integer.class);
        log.info("expiration_time: {}", expiration_time);

        // 토큰 생성
        Claims claims = Jwts.claims().setSubject(loginId);
        claims.put("userId", userId);
        claims.put("loginId", loginId);
        claims.put("auth", roles);
        String token = Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        log.info("생성된 token : {}", token);
    }
}