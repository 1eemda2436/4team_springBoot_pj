package com.example.team_pj_springboot.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.team_pj_springboot.dto.ErrorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

   private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
   @Override
   public void commence(HttpServletRequest request, HttpServletResponse response,
         AuthenticationException authException) throws IOException, ServletException {
      
      System.out.println("<<< UserAuthenticationEntryPoint - commence() >>>");
      
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);   // 승인되지 않은 HTTP코드를 반환한다.
      response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
      OBJECT_MAPPER.writeValue(response.getOutputStream(), new ErrorDTO("Unauthorized path"));
   }

}