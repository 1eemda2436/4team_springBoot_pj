package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.service.AnnualServiceImpl;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	private AnnualServiceImpl service;
		
	// 연차 신청 목록 조회 (Select)
	@GetMapping("/annualRequestsList")
	public List<AnnualDTO> annualRequestsList (HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualRequestsList ]");
		
		return service.annualRequestsList(req, model);
	}
	
	// 연차 상세 페이지 (Select)
	@GetMapping("/annualDetail/{annual_id}")
	public AnnualDTO annualDetail (@PathVariable int annual_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - annualDetail ]");
		
		return service.annualDetail(annual_id);
	}
	
	// 연차 상세페이지 승인 및 조회 (Update)
	@PutMapping("/annualConfirm/{annual_id}")
	public void annualConfirm (@PathVariable int annual_id, @RequestBody AnnualDTO dto) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualConfirm ]");
		
		service.annualConfirm(dto);
	}
	
	// 연차 상세페이지 반려 및 조회 (Update)
	@PutMapping("/annualReturn/{annual_id}")
	public void annualReturn (@PathVariable int annual_id, @RequestBody AnnualDTO dto) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualReturn ]");
		
		service.annualReturn(dto);
	}
	
	// 부서별 근태 현황/통계 조회 (Select)
	@GetMapping("/departmentAttendanceStatus/{depart_id}")
	public DepartmentDTO departmentAttendanceStatus (@PathVariable int depart_id) throws ServletException, IOException {
	    logger.info("[ AttendanceController - departmentAttendanceStatus ]");

	    System.out.println("depart_id : " + depart_id);
	    
	    return service.departmentAttendanceStatus(depart_id);
	}
	
	// 부서별 근태 현황(상세) 조회 (Select)
	@GetMapping("/departmentAtDetails/{depart_id}")
	public DepartmentDTO departmentAtDetails (@PathVariable int depart_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - departmentAtDetails ]");
		
		return service.departmentAtDetails(depart_id);
	}
	
	// 부서별 근태 통계(상세) 조회 (Select)
	@GetMapping("/departmentStDetails/{depart_id}")
	public DepartmentDTO departmentStDetails (@PathVariable int depart_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - departmentStDetails ]");
		
		return service.departmentStDetails(depart_id);
	}
	
	// 전사 근태 현황/통계 조회 (Select)
	@GetMapping("/companyStatus")
	public List<CompanyDTO> companyStatus(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("[ AttendanceController - companyStatus ]");
		
		return service.companyStatus(req, model);
	}
	
}
