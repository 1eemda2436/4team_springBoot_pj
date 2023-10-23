package com.example.team_pj_springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.DepartmentListDTO;

public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Integer> {
	
//	List<DepartmentDTO> findByDepartId(int departId);
	
	@Query("SELECT d.depart_id, d.depart_name, COUNT(t.team_id) AS teamCount, d.company_id " +
	           "FROM DepartmentDTO d " +
	           "LEFT JOIN TeamDTO t " +
	           "ON d.depart_id = t.depart_id " +
	           "GROUP BY d.depart_id, d.depart_name, d.company_id ")
	List<Object[]> findDepartmentsWithTeamCount();
	
	// 부서별 목록 띄우기용으로 추가 
	
	@Query("SELECT d.depart_id, d.depart_name " +
		       "FROM MemberDTO m " +
		       "LEFT JOIN TeamDTO t ON m.team_id = t.team_id " +
		       "LEFT JOIN DepartmentDTO d ON m.depart_id = d.depart_id " +
		       "LEFT JOIN ProjectDTO p ON d.depart_id = p.depart_id " +
		       "GROUP BY d.depart_id, d.depart_name " +
		       "ORDER BY d.depart_id ASC")
	List<Object[]> departList();
}

//@Query("SELECT new com.example.team_pj_springboot.dto.DepAttendanceDTO(d.depart_id, d.depart_name, m.name, ma.general_workin, ma.general_workout, ma.holiday_name, ma.gived_holiday) " +
//"FROM DepartmentDTO d  " +
//"INNER JOIN AttendanceDTO ma ON m.id = ma.id " +
//"INNER JOIN MemberDTO m ON m.depart_id = d.depart_id " +
//"WHERE m.id = :depart_id")
//Optional<DepAttendanceDTO> departmentAttendanceStatus(@Param("depart_id") int depart_id);