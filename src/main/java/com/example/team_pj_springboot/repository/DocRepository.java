package com.example.team_pj_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocDTO;

public interface DocRepository extends JpaRepository<DocDTO, Integer>{

	@Query("SELECT new com.example.team_pj_springboot.dto.DocAndCategoryDTO(d.doc_id, d.doc_date, m.name, d.doc_content, d.doc_attachment, c.category_name) " +
			"FROM DocDTO d " + 
			"JOIN MemberDTO m ON d.id = m.id " + 
			"JOIN CategoryDTO c ON d.category_id = c.category_id " +
			"WHERE d.doc_id = :doc_id")
	Optional<DocAndCategoryDTO> selectOneDoc(@Param("doc_id") int doc_id);
}

