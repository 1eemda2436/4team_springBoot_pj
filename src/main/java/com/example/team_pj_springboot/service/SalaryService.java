package com.example.team_pj_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.repository.CompanyRepository;
import com.example.team_pj_springboot.repository.MemberRepository;
import com.example.team_pj_springboot.repository.SalaryRepository;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;
import com.example.team_pj_springboot.dto.payStatementDTO;
import com.example.team_pj_springboot.mappers.UserMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;
    private final MemberRepository memberRepository;
    
    @Autowired
    public SalaryService(SalaryRepository salaryRepository, MemberRepository memberRepository) {
        this.salaryRepository = salaryRepository;
        this.memberRepository = memberRepository;
    }
    
    //관리자 급여관리 SalaryAndMemberDTO Join
    @Transactional
    public List<SalaryAndMemberDTO> getSalaryAndMemberInfo() {
        return salaryRepository.getSalaryAndMemberInfo();
    }
    
    //관리자 월급 명세서
    @Transactional
    public Optional<payStatementDTO> payStatementInfo(String id) {
    	return salaryRepository.payStatementInfo(id);
    }
    
    //관리자 인사관리 PersonnelInfo
    @Transactional
    public List<MemberDTO> getPersonnelInfo(){
    	return memberRepository.findAll();
    }
    
}