package com.example.team_pj_springboot.service;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.LoginDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.entities.Company;
import com.example.team_pj_springboot.entities.Member;
import com.example.team_pj_springboot.exception.AppException;
import com.example.team_pj_springboot.mappers.UserMapper;
import com.example.team_pj_springboot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

   private final UserRepository userRepository;
   private final UserMapper userMapper;
   private final PasswordEncoder passwordEncoder;
   
   public MemberDTO findById(String id) {
      System.out.println("UserService - findById()");
      
      Member member = userRepository.findById(id)
         .orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));
      
      return userMapper.toMemberDTO(member);
   }
   
   public Member login(LoginDTO loginDTO) {
      System.out.println("UserService - login()");
      
      Member member = userRepository.findById(loginDTO.getId())
            .orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));
      
      // 비밀번호 인코더를 사용하여 비밀번호가 일반 텍스트로 저장되는 것을 방지하지만 해시된 비밀번호는 읽을 수 없다.
      // import java.nio.CharBuffer; 주의
      if(passwordEncoder.matches(CharBuffer.wrap(loginDTO.getPwd()), member.getPwd())) {
         return member;
      }
      
      throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
   }
   
//   public Company join(CompanyDTO companyDTO) {
//      
//      System.out.println("<<< UserService - register() >>>");
//      System.out.println("FirstName : " + userDTO.getFirstName());
//      System.out.println("LastName : " + userDTO.getLastName());
//      System.out.println("Id : " + userDTO.getId());
//      System.out.println("Password : " + userDTO.getPassword());
//      System.out.println("Token : " + userDTO.getToken());
//      
//      // Optional : java.util
//      Optional<Member> optionalUser = userRepository.findById(userDTO.getId());
//      
//      if(optionalUser.isPresent()) {
//         throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
//      }
//      
//      Member user = new Member();
//      user.setId(userDTO.getId()); // username
//      user.setFirstName(userDTO.getFirstName());
//      user.setLastName(userDTO.getLastName());
//      user.setToken(userDTO.getToken());
//      
//      // passwordEncoder를 사용하여 암호를 일반텍스트로 저장하지 않고 해시한다.
//      user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
//      
//      Member saveUser = userRepository.save(user);
//      
//      return saveUser;
//   }
   
}