package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.ViewAndDocDTO;
import com.example.team_pj_springboot.dto.ViewDTO;

public interface ViewRepository extends JpaRepository<ViewDTO, Integer> {
//	@Query("SELECT new com.example.team_pj_springboot.dto.ViewAndDocDTO(v.doc_id, c.category_name, v.doc_title, m.name, v.doc_date, v.doc_read) " +
//			"FROM ViewDTO v " +
//			"JOIN CategoryDTO c ON v.category_id = c.category_id " +
//			"JOIN MemberDTO m ON v.id = m.id ")
//	List<ViewAndDocDTO> viewList();
	
}
