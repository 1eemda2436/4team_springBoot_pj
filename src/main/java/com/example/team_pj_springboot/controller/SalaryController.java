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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;
import com.example.team_pj_springboot.dto.payStatementDTO;
import com.example.team_pj_springboot.service.SalaryService;


@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/salary") // 엔드포인트에 "/api"를 추가
public class SalaryController {
	private static final Logger logger = LoggerFactory.getLogger(SalaryController.class);
	
	@Autowired
	private SalaryService service;
	
	//http://localhost:8081/salary/salaryMain

	//급여관리 메인 페이지
	@GetMapping("/salaryMain")
    public List<SalaryAndMemberDTO> salaryAndMemberInfo() {
		logger.info("[salaryAndMemberInfo]");
		
        return service.getSalaryAndMemberInfo();
    }
	
	//급여 관리 명세서
	@GetMapping("/PayStatement/{id}")
	public Optional<payStatementDTO> payStatement(@PathVariable String id) {
		logger.info("[payStatement]");

		Optional<payStatementDTO> dto = service.payStatementInfo(id);
		
		return dto;
	}
	
	//인사관리 메인 페이지
	@GetMapping("/personnel")
	public List<MemberDTO> personnelInfo(){
		logger.info("[personnelInfo]");
		
		return service.getPersonnelInfo();
	}
	
	
}
