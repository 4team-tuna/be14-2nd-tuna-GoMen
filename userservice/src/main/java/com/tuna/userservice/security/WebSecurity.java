package com.tuna.userservice.security;

import com.tuna.userservice.command.service.UserCommandService;
import com.tuna.userservice.query.service.UserQueryService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

@Configuration
public class WebSecurity {
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    private Environment env;
    private JwtUtil jwtUtil;
    private UserQueryService userService;

    @Autowired
    public WebSecurity(JwtAuthenticationProvider jwtAuthenticationProvider,
                       Environment env,
                       JwtUtil jwtUtil) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.env = env;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        /* 설명. 허용되는 경로 및 권한 설정 */
        http.authorizeHttpRequests(authz ->
                                authz.requestMatchers(new AntPathRequestMatcher("/user/delete")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/user/changeToMentor")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/user/**", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/user/**", "GET")).hasRole("USER")
                                .requestMatchers(new AntPathRequestMatcher("/user/**", "PATCH")).hasRole("USER")
                                .anyRequest().authenticated()
        )
        .authenticationManager(authenticationManager())
        /* 설명. session방식 안 쓰고 Jwt토큰 방식 쓰겠다. */
        .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilter(getAuthenticationFilter(authenticationManager()));

        http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, env, userService);
    }

}
