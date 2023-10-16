package com.example.team_pj_springboot.service;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.JoinDTO;
import com.example.team_pj_springboot.dto.LoginDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.exception.AppException;
import com.example.team_pj_springboot.mappers.UserMapper;
import com.example.team_pj_springboot.repository.CompanyRepository;
import com.example.team_pj_springboot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

   private final UserRepository userRepository;
   private final CompanyRepository companyRepository;
   private final UserMapper userMapper;
   private final PasswordEncoder passwordEncoder;
   
   public MemberDTO findById(String id) {
      System.out.println("UserService - findById()");
      
      MemberDTO memberDTO = userRepository.findById(id)
         .orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));
      
      return userMapper.toMemberDTO(memberDTO);
   }
   
   public MemberDTO login(LoginDTO loginDTO) {
      System.out.println("UserService - login()");
      
      MemberDTO member = userRepository.findById(loginDTO.getId())
            .orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));
      
      // 비밀번호 인코더를 사용하여 비밀번호가 일반 텍스트로 저장되는 것을 방지하지만 해시된 비밀번호는 읽을 수 없다.
      // import java.nio.CharBuffer; 주의
      if(passwordEncoder.matches(CharBuffer.wrap(loginDTO.getPwd()), member.getPwd())) {
         return member;
      }
      
      throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
   }
   
   
   public CompanyDTO companyJoin(JoinDTO joinDTO) {
      
      System.out.println("UserService - join()");
      
      System.out.println(joinDTO);
      
      CompanyDTO company = new CompanyDTO();
      MemberDTO member = new MemberDTO();
      
      company.setCompanyId(joinDTO.getCompanyDTO().getCompanyId());
      company.setName(joinDTO.getCompanyDTO().getName());
      company.setAddress(joinDTO.getCompanyDTO().getAddress());
      company.setEmployees(joinDTO.getCompanyDTO().getEmployees());
      company.setManager(joinDTO.getCompanyDTO().getManager());
      company.setEmail(joinDTO.getCompanyDTO().getEmail());
      company.setWork_in(joinDTO.getCompanyDTO().getWork_in());
      company.setWork_out(joinDTO.getCompanyDTO().getWork_out());
      company.setKey(joinDTO.getCompanyDTO().getKey());
      company.setAuthoriry(joinDTO.getCompanyDTO().getAuthoriry());
      company.setEnabled(joinDTO.getCompanyDTO().getEnabled());
//      member.setId(joinDTO.getLoginDTO().getId());
//      // passwordEncoder를 사용하여 암호를 일반텍스트로 저장하지 않고 해시한다.
//      member.setPwd(passwordEncoder.encode(CharBuffer.wrap(joinDTO.getLoginDTO().getPwd())));
//      
//      Member saveUser = userRepository.save(member);
      
      CompanyDTO saveCompany = companyRepository.save(company);
      
      return saveCompany;
   }
   
}