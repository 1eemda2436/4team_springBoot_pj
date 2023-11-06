package com.example.team_pj_springboot.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{
   
   private final UserAuthProvider userAuthProvider;

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
         throws ServletException, IOException {

      System.out.println("<<< JwtAuthFilter - doFilterInternal >>>");
      
      String header = request.getHeader(HttpHeaders.AUTHORIZATION);
      System.out.println("header : " + header);
      
      if(header != null) {
         String[] elements = header.split(" ");
         System.out.println("elements : " + elements);
         
         if(elements.length == 2 && "Bearer".equals(elements[0])) {
            try {
               SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(elements[1]));
            } catch(RuntimeException e) {
               SecurityContextHolder.clearContext();
               throw e;
            }
         }
      }
      filterChain.doFilter(request, response);
   }
}



