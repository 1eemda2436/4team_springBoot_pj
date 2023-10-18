package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.team_pj_springboot.dto.MemberDTO;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, String> {
	
}
