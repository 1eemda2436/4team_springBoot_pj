package com.example.team_pj_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocAndDraftDTO;
import com.example.team_pj_springboot.dto.DocAndTemporaryDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;
import com.example.team_pj_springboot.dto.ViewAndDocDTO;
import com.example.team_pj_springboot.dto.ViewDTO;
import com.example.team_pj_springboot.service.DocService;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/doc")
public class DocController {

	private static final Logger logger = LoggerFactory.getLogger(DocController.class);
	
	@Autowired
	private DocService service;
	
	// http://localhost:8081/doc/adminTotal
	// 어드민통합문서함 - 연결완료
	@GetMapping("/adminTotal")
	public List<ApprovalIngAndDocDTO> selectAdmin() {
		logger.info("<<< 컨트롤러 - selectMember >>>");
		
		return service.approvalIngList();
	}
	
	// 게스트통합문서함 - 연결완료
	@GetMapping("/guestTotal")
	public List<DocAndDraftDTO> selectGuest() {
		logger.info("<<< 컨트롤러 - selectMember >>>");
		
		return service.draftList();
	}
	
	// 기안문서함 - 연결완료
	@GetMapping("/draft")
	public List<DocAndDraftDTO> draftList() {
		logger.info("<<< 컨트롤러 - draftList >>>");
		
		return service.draftList();
	}
	
	// 회람문서함 안됌
	@GetMapping("/view")
	public List<ViewDTO> viewList() {
		logger.info("<<< 컨트롤러 - viewList >>>");
		
		return service.viewList();
	}
	
	// 임시저장목록 - 연결완료
	@GetMapping("/temporary")
	public List<DocAndTemporaryDTO> temporaryList() {
		logger.info("<<< 컨트롤러 - temporaryList >>>");
		
		return service.temporaryList();
	}
	
	// 결재완료문서함 - 연결완료
	@GetMapping("/approvalEnd")
	public List<ApprovalEndAndDocDTO> approvalEndList() {
		logger.info("<<< 컨트롤러 - approvalEndList >>>");
		
		return service.approvalEndList();
	}
	
	// 결재예정문서함 - 연결완료
	@GetMapping("/approvalIng")
	public List<ApprovalIngAndDocDTO> approvalIngList() {
		logger.info("<<< 컨트롤러 - approvalIngList >>>");
		
		return service.approvalIngList();
	}
	
	// 결재반려문서함 - 연결완료
	@GetMapping("/approvalBack")
	public List<ApprovalBackAndDocDTO> approvalBackList() {
		logger.info("<<< 컨트롤러 - approvalBackList >>>");
		
		return service.approvalBackList();
	}
	
	// 문서작성페이지 안됌
	@PostMapping("/insert")
	public String insertDoc(@ModelAttribute("dto") DocDTO dto, Model model) {
		logger.info("<<< 컨트롤러 - insertDoc >>>");
		
		service.insertDoc(dto);
		
		return "redirect:/";
		
	}
	
	// 문서상세페이지 - 연결완료
	@GetMapping("/detail/{doc_id}")
	public Optional<DocAndCategoryDTO> selectDoc(@PathVariable int doc_id) {
		logger.info("<<< 컨트롤러 - selectDoc >>>");
		logger.info("doc_id: " + doc_id);
		
		Optional<DocAndCategoryDTO> dto = service.selectDoc(doc_id);
		
		return dto;
	}
	
	// 결재문서상세페이지
	@GetMapping("/adminDetail/{approval_id}")
	public Optional<ApprovalAndDocDTO> selectApp(@PathVariable int approval_id) {
		logger.info("<<< 컨트롤러 - selectDoc >>>");
		logger.info("approval_id: " + approval_id);
		
		Optional<ApprovalAndDocDTO> dto = service.selectApp(approval_id);
		
		return dto;
	}
	
	// 문서수정페이지 안됌
	@PutMapping("/update/{doc_id}")
	public void updateDoc(@PathVariable(name="doc_id") int doc_id, Model model) {
		logger.info("<<< 컨트롤러 - updateDoc >>>");
		
		DocDTO dto = service.updateDoc(doc_id);
		model.addAttribute("dto", dto);
		
	}
	
	// 문서삭제페이지 안됌
	@DeleteMapping("/delete/{doc_id}")
	public void deleteDoc(@PathVariable(name="id") int doc_id, Model mode) {
		logger.info("<<< 컨트롤러 - updateDoc >>>");
		
		service.deleteDoc(doc_id); 
		
	}
	
}	