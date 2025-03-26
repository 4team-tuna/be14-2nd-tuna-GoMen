package com.tuna.gomen.security;

import com.tuna.gomen.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtUtil {

    private final Key key;
    private final UserService userService;

    @Autowired
    public JwtUtil(
            @Value("${token.secret}") String secretKey,
            UserService userService) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.userService = userService;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException e) {
            log.info("유효하지 않은 JWT Token");
        } catch (ExpiredJwtException e) {
            log.info("만료기간이 지남");
        } catch (UnsupportedJwtException e) {
            log.info("지원하지 않는 JWT Token");
        } catch (IllegalArgumentException e) {
            log.info("토큰의 클레임이 비어있음");
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);

        UserDetails userDetails = userService.loadUserDetailsByLoginId(claims.getSubject());

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(claims.get("auth") == null){
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        } else {
            authorities = Arrays.stream(claims.get("auth").toString()
                            .replace("[", "")
                            .replace("]", "")
                            .split(", "))
                    .map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList());
        }
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    /* 설명. 토큰에서 payload만 추출 */
    private Claims parseClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
