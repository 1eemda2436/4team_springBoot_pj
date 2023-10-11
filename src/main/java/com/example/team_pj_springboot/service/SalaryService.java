package com.example.team_pj_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dao.MemberRepository;
import com.example.team_pj_springboot.dao.SalaryRepository;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;
    private final MemberRepository memberRepository;
    
    @Autowired
    public SalaryService(SalaryRepository salaryRepository, 
    					 MemberRepository memberRepository) {
        this.salaryRepository = salaryRepository;
        this.memberRepository = memberRepository;
    }
    
    //관리자 급여관리 SalaryAndMemberDTO Join
    @Transactional
    public List<SalaryAndMemberDTO> getSalaryAndMemberInfo() {
        return salaryRepository.getSalaryAndMemberInfo();
    }
    
    @Transactional
    public List<MemberDTO> getPersonnelInfo(){
    	return memberRepository.findAll();
    }
    
}