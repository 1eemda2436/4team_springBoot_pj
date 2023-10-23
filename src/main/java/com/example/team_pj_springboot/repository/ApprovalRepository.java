package com.example.team_pj_springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;

public interface ApprovalRepository extends JpaRepository<ApprovalDTO, Integer> {
	@Query("SELECT new com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO(d.doc_id, d.doc_title, d.doc_status, c.category_name, m.name, a.approval_date, a.approval_endDate) " + 
			"FROM DocDTO d " + 
			"JOIN CategoryDTO c ON d.category_id = c.category_id " + 
			"JOIN MemberDTO m ON d.id = m.id " + 
			"JOIN ApprovalDTO a ON d.doc_id = a.doc_id " + 
			"WHERE d.doc_status = '완료' " + 
			"ORDER BY a.approval_date DESC")
	List<ApprovalEndAndDocDTO> ApprovalEndList();
	
	@Query("SELECT new com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO(d.doc_id, d.doc_title, d.doc_status, c.category_name, m.name, a.approval_date) " + 
			"FROM DocDTO d " + 
			"JOIN CategoryDTO c ON d.category_id = c.category_id " + 
			"JOIN MemberDTO m ON d.id = m.id " + 
			"JOIN ApprovalDTO a ON d.doc_id = a.doc_id " + 
			"WHERE d.doc_status = '반려' " + 
			"ORDER BY a.approval_date DESC")
	List<ApprovalBackAndDocDTO> approvalBackList();
	
	@Query("SELECT new com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO(d.doc_id, d.doc_title, d.doc_status, c.category_name, m.name, a.approval_date) " + 
			"FROM DocDTO d " + 
			"JOIN CategoryDTO c ON d.category_id = c.category_id " + 
			"JOIN MemberDTO m ON d.id = m.id " + 
			"JOIN ApprovalDTO a ON d.doc_id = a.doc_id " + 
			"WHERE d.doc_status = '진행' " + 
			"ORDER BY a.approval_date DESC")
	List<ApprovalIngAndDocDTO> approvalIngList();
	
	@Query("SELECT new com.example.team_pj_springboot.dto.ApprovalAndDocDTO(d.doc_id, ad.approval_id, m.name, ad.approval_date, ad.approval_content, d.doc_title, d.doc_content, d.doc_attachment) " +
			"FROM DocDTO d " + 
			"JOIN MemberDTO m ON d.id = m.id " + 
			"JOIN ApprovalDTO ad ON d.doc_id = ad.doc_id " +
			"WHERE d.doc_id = :doc_id")
	Optional<ApprovalAndDocDTO> selectApp(@Param("doc_id") int doc_id);
}
