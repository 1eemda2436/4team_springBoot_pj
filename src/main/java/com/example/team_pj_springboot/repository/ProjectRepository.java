package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.ProjectAndTeamDTO;
import com.example.team_pj_springboot.dto.ProjectDTO;

// 프로젝트 repository
public interface ProjectRepository extends JpaRepository<ProjectDTO, Integer> {

//	@Query("SELECT p.pj_id, p.pj_name, p.deadline_s, p.deadline_e, t.team_id, t.team_name, t.depart_id " +
//			"FROM ProjectDTO p " +
//			"JOIN TeamDTO t ON p.depart_id=t.depart_id " +
//			"ORDER BY p.pj_id ASC") 
//	List<ProjectAndTeamDTO> ProjectList();
	
	@Query("SELECT new com.example.team_pj_springboot.dto.ProjectAndTeamDTO(p.pj_id, p.pj_name, p.deadline_s, p.deadline_e, t.team_id, t.team_name, t.depart_id) " +
	           "FROM ProjectDTO p " +
	           "JOIN TeamDTO t ON p.depart_id=t.depart_id " +
	           "ORDER BY p.pj_id ASC")
	    List<ProjectAndTeamDTO> ProjectList();
	
}
