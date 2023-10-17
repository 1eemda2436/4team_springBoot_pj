package com.example.team_pj_springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Integer> {
	
//	List<DepartmentDTO> findByDepartId(int departId);
	
}

//@Query("SELECT new com.example.team_pj_springboot.dto.DepAttendanceDTO(d.depart_id, d.depart_name, m.name, ma.general_workin, ma.general_workout, ma.holiday_name, ma.gived_holiday) " +
//"FROM DepartmentDTO d  " +
//"INNER JOIN AttendanceDTO ma ON m.id = ma.id " +
//"INNER JOIN MemberDTO m ON m.depart_id = d.depart_id " +
//"WHERE m.id = :depart_id")
//Optional<DepAttendanceDTO> departmentAttendanceStatus(@Param("depart_id") int depart_id);
