package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.MyPageDTO;

public interface MyPageRepository extends JpaRepository<MyPageDTO, String>{

//	@Query("SELECT m FROM MyPageDTO m WHERE m.id = :id")
//	List<MyPageDTO> findMemeberByMyPageDTO(@Param("id") String id);
	
	//유진
	@Query("SELECT new com.example.team_pj_springboot.dto.MyPageDTO(m.id, m.company_id, m.pwd, m.name, m.email, " +
	           "m.tel, m.profile, m.hireday, m.resignation, m.birthday, m.resident, m.depart_id, m.team_id, " +
	           "m.rank, m.salary, m.bank, m.contract, m.sign, m.e_state, m.state, m.key, m.enabled, m.authority, " +
	           "m.token, d.depart_name, t.team_name) " +
	           "FROM MyPageDTO m " +
	           "LEFT JOIN TeamDTO t ON m.team_id = t.team_id " +
	           "LEFT JOIN DepartmentDTO d ON m.depart_id = d.depart_id " +
	           "WHERE m.id = :id")
	    MyPageDTO findMemeberByMyPageDTO(@Param("id") String id);
	


}
