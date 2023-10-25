package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.UserRoleDTO;

public interface UserRoleRepository extends JpaRepository<UserRoleDTO, Integer>{
	

} 