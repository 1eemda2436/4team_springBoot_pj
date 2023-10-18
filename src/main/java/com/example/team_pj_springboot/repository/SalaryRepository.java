package com.example.team_pj_springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;
import com.example.team_pj_springboot.dto.payStatementDTO;

public interface SalaryRepository extends JpaRepository<SalaryDTO, Integer> {
	@Query("SELECT new com.example.team_pj_springboot.dto.SalaryAndMemberDTO(s.s_id, m.id, m.name, m.resident, m.contract, m.depart_id, m.rank, m.state, m.e_state, s.salary) " +
	        "FROM SalaryDTO s " +
	        "JOIN MemberDTO m ON s.id = m.id")
	List<SalaryAndMemberDTO> getSalaryAndMemberInfo();

	@Query("SELECT new com.example.team_pj_springboot.dto.payStatementDTO(s.s_id, m.id, m.name, m.rank, s.salary, s.income_tax, s.local_tax, s.national_pension, s.health_insurance, s.c_health_insurance, s.employment_insurance, s.bonus, s.allowance, s.overtime_pay, s.food_pay, s.t_pay, s.amount_money, s.amount_tax)"+
		       "FROM SalaryDTO s " +
		       "JOIN MemberDTO m ON s.id = m.id " + 
		       "WHERE m.id = :memberId") // :memberId와 @Param("memberId")를 일치시킴
	Optional<payStatementDTO> payStatementInfo(@Param("memberId") String memberId);

	
}
