package com.example.team_pj_springboot.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.PayStatementDTO;
import com.example.team_pj_springboot.service.SalaryService;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/guest/salary") 
public class SalaryGuestController {
	private static final Logger logger = LoggerFactory.getLogger(SalaryController.class);
	
	@Autowired
	private SalaryService service;
	
	//급여 관리 명세서
	@GetMapping("/PayStatement/{id}")
	public Optional<PayStatementDTO> payStatement(@PathVariable String id) {
		logger.info("[salary - payStatement]");

		Optional<PayStatementDTO> dto = service.payStatementInfo(id);
		
		return dto;
	}
}
