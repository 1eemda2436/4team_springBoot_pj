package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;

public interface SalaryRepository extends JpaRepository<SalaryDTO, Integer> {
	@Query("SELECT new com.example.team_pj_springboot.dto.SalaryAndMemberDTO(s.s_id, m.id, m.name, m.resident, m.contract, m.depart_id, m.rank, m.state, m.e_state, s.salary) " +
	        "FROM SalaryDTO s " +
	        "JOIN MemberDTO m ON s.id = m.id")
	List<SalaryAndMemberDTO> getSalaryAndMemberInfo();
	
}
