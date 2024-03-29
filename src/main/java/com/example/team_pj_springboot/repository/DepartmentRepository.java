package com.example.team_pj_springboot.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.DepartmentListDTO;

public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Integer> {

	//관리자 부서 현황 
	@Query("SELECT d.depart_id, d.depart_name, COUNT(t.team_id) AS teamCount, d.company_id " +
	           "FROM DepartmentDTO d " +
	           "LEFT JOIN TeamDTO t " +
	           "ON d.depart_id = t.depart_id " +
	           "WHERE d.show = 'Y' " +
	           "AND t.show = 'Y' " +
	           "GROUP BY d.depart_id, d.depart_name, d.company_id ")
	List<Object[]> findDepartmentsWithTeamCount();
		
	//부서 삭제 SHOW → N
	@Modifying //수정
	@Transactional // 한명령어의 단위
	@Query("UPDATE DepartmentDTO d SET d.show = 'N' WHERE d.depart_id = :depart_id")
	void DepartmentDeleteQuery(@Param("depart_id") int depart_id);

	@Query("SELECT d FROM DepartmentDTO d WHERE d.company_id = :company_id")
	List<DepartmentDTO> findByCompany_id(@Param("company_id") String company_id);

}
