package com.example.team_pj_springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDoc2DTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocAndDraftDTO;
import com.example.team_pj_springboot.dto.DocDTO;

public interface DocRepository extends JpaRepository<DocDTO, Integer>{
   @Query("SELECT new com.example.team_pj_springboot.dto.DocAndDraftDTO(d.doc_id, c.category_name, d.doc_title, m.name, d.doc_date, d.doc_status, d.sign) " + 
         "FROM DocDTO d " + 
         "JOIN CategoryDTO c ON d.category_id = c.category_id " + 
         "JOIN MemberDTO m ON d.id = m.id")
   List<DocAndDraftDTO> draftList();

   @Query("SELECT new com.example.team_pj_springboot.dto.DocAndCategoryDTO(d.doc_id, d.doc_date, m.name, d.doc_title, d.doc_content, d.doc_attachment, c.category_name, d.sign) " +
         "FROM DocDTO d " + 
         "JOIN MemberDTO m ON d.id = m.id " + 
         "JOIN CategoryDTO c ON d.category_id = c.category_id " +
         "WHERE d.doc_id = :doc_id")
   Optional<DocAndCategoryDTO> selectOneDoc(@Param("doc_id") int doc_id); 
   
   @Query("SELECT new com.example.team_pj_springboot.dto.DocAndDraftDTO(d.doc_id, c.category_name, d.doc_title, m.name, d.doc_date, d.doc_status, d.sign) " + 
            "FROM DocDTO d " + 
            "JOIN CategoryDTO c ON d.category_id = c.category_id " + 
            "JOIN MemberDTO m ON d.id = m.id")
      List<DocAndDraftDTO> temporaryList();
   
   @Query("SELECT new com.example.team_pj_springboot.dto.ApprovalIngAndDoc2DTO(d.doc_id, d.doc_title, d.doc_status, m.name, d.doc_date) " + 
	         "FROM DocDTO d " + 
	         "JOIN MemberDTO m ON d.id = m.id " + 
	         "WHERE d.doc_status = '진행' " + 
	         "ORDER BY d.doc_id DESC")
	   List<ApprovalIngAndDoc2DTO> approvalIngList2();
   
   @Query("SELECT new com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO(d.doc_id, d.doc_title, d.doc_status, m.name, d.doc_date) " + 
	         "FROM DocDTO d " + 
	         "JOIN MemberDTO m ON d.id = m.id " + 
	         "WHERE d.doc_status = '진행' " + 
	         "ORDER BY d.doc_id DESC")
	   List<ApprovalIngAndDocDTO> approvalIngList();
   
   @Query("SELECT new com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO(d.doc_id, d.doc_title, d.doc_status, m.name, d.doc_date) " + 
	         "FROM DocDTO d " + 
	         "JOIN MemberDTO m ON d.id = m.id " + 
	         "WHERE d.doc_status IN ('진행', '완료', '반려') " + 
	         "ORDER BY d.doc_id DESC")
	   List<ApprovalIngAndDocDTO> approvalAllList();
   
   @Query("SELECT new com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO(d.doc_id, d.doc_title, d.doc_status, m.name, d.approval_date) " + 
	         "FROM DocDTO d " +  
	         "JOIN MemberDTO m ON d.id = m.id " + 
	         "WHERE d.doc_status = '완료' " + 
	         "ORDER BY d.doc_id DESC")
	   List<ApprovalEndAndDocDTO> ApprovalEndList();
   
   @Query("SELECT new com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO(d.doc_id, d.doc_title, d.doc_status, m.name, d.approval_date) " + 
	         "FROM DocDTO d " + 
	         "JOIN MemberDTO m ON d.id = m.id " + 
	         "WHERE d.doc_status = '반려' " + 
	         "ORDER BY d.doc_id DESC")
	   List<ApprovalBackAndDocDTO> approvalBackList();
   
   @Query("SELECT new com.example.team_pj_springboot.dto.ApprovalAndDocDTO(d.doc_id, m.name, d.doc_date, d.approval_content, d.doc_title, d.doc_content, d.doc_attachment, d.sign, d.admin_sign) " +
         "FROM DocDTO d " + 
         "JOIN MemberDTO m ON d.id = m.id " + 
         "WHERE d.doc_id = :doc_id")
   Optional<ApprovalAndDocDTO> selectApp(@Param("doc_id") int doc_id);
}