package com.example.team_pj_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
        http
            .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
            .and()
            .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests((requests) -> requests
//            	.antMatchers("/guest/*").hasAnyRole("USER", "user", "ROLE_USER", "role_user") // user 권한이 있는 사용자만 액세스 가능
//            	.antMatchers("/admin/**", "/guest/**").hasAnyRole("MANAGER") // manager 권한이 있는 사용자만 액세스 가능
//            	.antMatchers("/", "/join", "/all/*").permitAll() // 공개 엔드포인트
        		.antMatchers("/**").permitAll()
            	.anyRequest().authenticated());
        return http.build();
    }
}

//.antMatchers(HttpMethod.POST, "/", "/join").permitAll()
//.antMatchers("/**").permitAll()