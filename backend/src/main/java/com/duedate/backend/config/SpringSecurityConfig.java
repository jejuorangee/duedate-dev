package com.duedate.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
  // 비밀번호 암호화 Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  // HTTP 보안 설정
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
    httpSecurity
      .csrf(csrf -> csrf.disable()) // CSRF 비활성화
      .authorizeHttpRequests(auth -> auth
        // 회원가입 및 로그인 페이지는 비인증 사용자도 접근 가능
        .requestMatchers("/api/user/signup", "/api/user/login").permitAll()
        // 로그아웃 페이지는 로그인된 사용자만 접근 가능
        .requestMatchers("/api/user/logout").authenticated()
        // 그 외 요청은 허용
        .anyRequest().permitAll())
      // 기본 로그인 폼 비활성화
      .formLogin(login -> login.disable());
    
    return httpSecurity.build();
  }
}
