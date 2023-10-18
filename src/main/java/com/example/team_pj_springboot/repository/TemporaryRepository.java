package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.DocAndTemporaryDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;

public interface TemporaryRepository extends JpaRepository<TemporaryDTO, Integer> {
	@Query("SELECT new com.example.team_pj_springboot.dto.DocAndTemporaryDTO(d.doc_id, d.doc_title, ds.save_date) " + 
			"FROM TemporaryDTO ds " + 
			"JOIN DocDTO d ON ds.doc_id = d.doc_id " + 
			"ORDER BY ds.save_date DESC")
	List<DocAndTemporaryDTO> temporaryList();
}
