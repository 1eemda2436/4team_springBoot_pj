package com.example.team_pj_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;   // 경로주의 .web.
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
   
   private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
   private final UserAuthProvider userAuthProvider;
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      
      System.out.println("<<< SecurityConfig - securityFilterChain() >>>");
      
      http
       .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
       .and()
       .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class) // Spring Security의 인증필터앞에 JWT 필터를 추가
       .csrf().disable()   // 복잡성을 피하기 위해 csrf를 비활성화한다.
       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // stateless 애플리케이션을 스프링에게 전달하면 스프링에서 세션과 쿠키를 생성하지 않는다.
       .and()
       .authorizeHttpRequests((requests) -> requests
             .antMatchers(HttpMethod.POST, "/", "/join").permitAll()   // 인증이 필요하지 않은 유일한 엔드포인트이며, 리액트의 url과 일치시켜야 한다.
             .anyRequest().authenticated()   // 나머지 엔드포인트는 인증을 받아야 함
             );
      
      return http.build();
   }
   
}