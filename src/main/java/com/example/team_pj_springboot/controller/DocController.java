package com.example.team_pj_springboot.controller;

import java.util.List;


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

import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;
import com.example.team_pj_springboot.dto.ViewDTO;
import com.example.team_pj_springboot.service.DocService;

@CrossOrigin(origins="**", maxAge=3600)
@RestController
public class DocController {

	private static final Logger logger = LoggerFactory.getLogger(DocController.class);
	
	@Autowired
	private DocService service;
	
	// http://localhost:8081/
	// 통합문서함
	@GetMapping("/total")
	public List<DocDTO> selectMember(Model model) {
		logger.info("<<< 컨트롤러 - selectMember >>>");
		
		List<DocDTO> list = service.draftList();
		model.addAttribute("list", list);
		
		return service.draftList();
	}
	
	// 기안문서함
	@GetMapping("/draft")
	public List<DocDTO> draftList(Model model) {
		logger.info("<<< 컨트롤러 - draftList >>>");
		
		List<DocDTO> list = service.draftList();
		model.addAttribute("list", list);
		
		return service.draftList();
	}
	
	// 회람문서함 안됌
	@GetMapping("/view")
	public List<ViewDTO> viewList(Model model) {
		logger.info("<<< 컨트롤러 - viewList >>>");
		
		List<ViewDTO> list = service.viewList();
		model.addAttribute("list", list);
		
		return service.viewList();
	}
	
	// 임시저장목록
	@GetMapping("/temporary")
	public List<TemporaryDTO> temporaryList(Model model) {
		logger.info("<<< 컨트롤러 - temporaryList >>>");
		
		List<TemporaryDTO> list = service.temporaryList();
		model.addAttribute("list", list);
		
		return service.temporaryList();
	}
	
	// 결재완료문서함 안됌
	@GetMapping("/approvalEnd")
	public List<ApprovalDTO> approvalEndList(Model model) {
		logger.info("<<< 컨트롤러 - approvalEndList >>>");
		
		List<ApprovalDTO> list = service.approvalEndList();
		model.addAttribute("list", list);
		
		return service.approvalEndList();
	}
	
	// 결재예정문서함 안됌
	@GetMapping("/approvalIng")
	public List<ApprovalDTO> approvalIngList(Model model) {
		logger.info("<<< 컨트롤러 - approvalIngList >>>");
		
		List<ApprovalDTO> list = service.approvalIngList();
		model.addAttribute("list", list);
		
		return service.approvalIngList();
	}
	
	// 결재반려문서함 안됌
	@GetMapping("/approvalBack")
	public List<ApprovalDTO> approvalBackList(Model model) {
		logger.info("<<< 컨트롤러 - approvalBackList >>>");
		
		List<ApprovalDTO> list = service.approvalBackList();
		model.addAttribute("list", list);
		
		return service.approvalBackList();
	}
	
	// 문서작성페이지 안됌
	@PostMapping("/insert")
	public void insertDoc(Model model) {
		logger.info("<<< 컨트롤러 - insertDoc >>>");
		
		DocDTO dto = new DocDTO();
		model.addAttribute("dto", dto);
		
	}
	
	// 문서작성저장 안됌
	@PutMapping("/save")
	public String insertSave(@ModelAttribute("dto") DocDTO dto) {
		logger.info("<<< 컨트롤러 - insertSave >>>");
		
		service.insertDoc(dto);
		return "redirect:/";
	}
	
	// 문서상세페이지
	@GetMapping("/detail/{doc_id}")
	public DocDTO selectDoc(@PathVariable(name="doc_id") int doc_id, Model model) {
		logger.info("<<< 컨트롤러 - selectDoc >>>");
		
		DocDTO dto = service.selectDoc(doc_id);
		model.addAttribute("dto", dto);
		
		return service.selectDoc(doc_id);
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