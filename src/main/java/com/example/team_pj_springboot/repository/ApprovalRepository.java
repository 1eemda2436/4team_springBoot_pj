package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.ApprovalDTO;

public interface ApprovalRepository extends JpaRepository<ApprovalDTO, Integer> {
//	@Query("SELECT d.doc_id, d.doc_title, d.doc_status, c.category_name, m.name, a.approval_date, a.approval_endDate " + 
//			"FROM doc d " + 
//			"JOIN doc_category c ON d.category_id = c.category_id " + 
//			"JOIN member m ON d.id = m.id " + 
//			"JOIN doc_approval a ON d.doc_id = a.doc_id " + 
//			"WHERE d.doc_status = 'G' " + 
//			"ORDER BY a.approval_date DESC")
//	List<ApprovalDTO> ApprovalEndList();
}
