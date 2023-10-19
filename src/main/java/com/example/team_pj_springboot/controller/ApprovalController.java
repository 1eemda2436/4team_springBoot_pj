package com.example.team_pj_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.service.DocService;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/admin/doc")
public class ApprovalController {
	
	private static final Logger logger = LoggerFactory.getLogger(DocController.class);
	
	@Autowired
	private DocService service;
	
	// http://localhost:8081/doc/adminTotal
	// 어드민메인 - 연결완료
	@GetMapping("/adminTotal")
	public List<ApprovalIngAndDocDTO> selectAdmin() {
		logger.info("<<< 컨트롤러 - selectMember >>>");
		
		return service.approvalIngList();
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
	
	// 결재문서상세페이지
	@GetMapping("/adminDetail/{doc_id}")
	public Optional<ApprovalAndDocDTO> selectApp(@PathVariable int doc_id) {
		logger.info("<<< 컨트롤러 - selectApp >>>");
		logger.info("doc_id: " + doc_id);
		
		Optional<ApprovalAndDocDTO> dto = service.selectApp(doc_id);
		
		return dto;
	}
 
}
