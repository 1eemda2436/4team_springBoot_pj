package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.personnelMemberDTO;

public interface PersonnelRepository extends JpaRepository<personnelMemberDTO, String> {
	
	@Query("SELECT MAX(id) FROM personnelMemberDTO")
	String findMaxId();
}

