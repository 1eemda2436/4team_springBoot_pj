package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;
import com.example.team_pj_springboot.dto.ViewDTO;

public interface DocService {
	
	// 통합문서함
	public MemberDTO selectMember(String id);

	// 기안문서함
	public List<DocDTO> draftList();
	
	// 회람문서함
	public List<ViewDTO> viewList();
	
	// 임시저장목록
	public List<TemporaryDTO> temporaryList();
	
	// 결재완료문서함
	public List<ApprovalDTO> approvalEndList();
	
	// 결재예정문서함
	public List<ApprovalDTO> approvalIngList();
	
	// 결재반려문서함
	public List<ApprovalDTO> approvalBackList();
	
	// 문서작성페이지
	public DocDTO insertDoc(DocDTO dto);
	
	// 문서상세페이지
	public Optional<DocAndCategoryDTO> selectDoc(int doc_id);
	
	// 문서수정페이지
	public DocDTO updateDoc(int doc_id);
	
	// 문서삭제페이지
	public void deleteDoc(int doc_id);
	
}
