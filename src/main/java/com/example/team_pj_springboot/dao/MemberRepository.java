package com.example.team_pj_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.MemberDTO;

public interface MemberRepository extends JpaRepository<MemberDTO, String>{

}
