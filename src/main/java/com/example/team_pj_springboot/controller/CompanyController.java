package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.service.CompanyService;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/admin/company")
public class CompanyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService service;
	 
	//http://localhost:8081/company
	//admin 메인 페이지 회사 정보 출력
	@GetMapping("/{company_id}")
	public Optional<CompanyDTO> adminsMain(@PathVariable(name="company_id") String companyId) 
			throws ServletException, IOException{
		logger.info("[adminsMain]");
		
		Optional<CompanyDTO> dto = service.main(companyId);
		
		return dto;
	}
	
}
