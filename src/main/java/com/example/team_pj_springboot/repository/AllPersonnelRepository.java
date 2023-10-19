package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;


public interface AllPersonnelRepository extends JpaRepository<AllPersonnelDTO, String>{
	@Query("SELECT " +
		       "m.id, m.pwd, m.name, m.email, m.tel, m.profile, m.hireday, m.resignation, "
		       + "m.birthday, m.resident, "
		       + "m.depart_id, "
		       + "d.depart_name, "
		       + "m.team_id, "
		       + "t.team_name, "
		       + "m.rank, m.salary, m.bank, m.contract, m.sign, m.state, m.e_state, "
		       + "m.key, m.authority, m.enabled " +
		       "FROM MemberDTO m " +
		       "LEFT JOIN DepartmentDTO d ON m.depart_id = d.depart_id " +
		       "LEFT JOIN TeamDTO t ON m.team_id = t.team_id")
	List<AllPersonnelDTO> findPersonnelMembersWithDetails();
}
