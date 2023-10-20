package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.ComAttendanceDTO;
import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.service.AdminServiceImpl;
import com.example.team_pj_springboot.service.DepAttenService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping(value = "/admin/attendance")
@RequiredArgsConstructor
public class AttendanceAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceAdminController.class);
	
	@Autowired
	private AdminServiceImpl service;
	
	@Autowired
	private DepAttenService depservice;
	
	// 연차 상세페이지 승인 및 조회 (Update)
	@PutMapping("/annualConfirm/{annual_id}")
	public void annualConfirm (@PathVariable int annual_id) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualConfirm ]");
		
		service.annualConfirm(annual_id);
	}
	
	// 연차 상세페이지 반려 및 조회 (Update)
	@PutMapping("/annualReturn/{annual_id}")
	public void annualReturn (@PathVariable int annual_id) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualReturn ]");
		
		service.annualReturn(annual_id);
	}
	
	// 휴가 상세페이지 승인 및 조회 (Update)
	@PutMapping("/vacationConfirm/{vacation_id}")
	public void vacationConfirm (@PathVariable int vacation_id) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - vacationConfirm ]");
		
		service.vacationConfirm(vacation_id);
	}
	
	// 휴가 상세페이지 반려 및 조회 (Update)
	@PutMapping("/vacationReturn/{vacation_id}")
	public void vacationReturn (@PathVariable int vacation_id) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - vacationReturn ]");
		
		service.vacationReturn(vacation_id);
	}
	
	// 부서별 근태 현황/통계 조회 (Select)
	@GetMapping("/departmentAttendanceStatus/{depart_id}")
	public DepAttendanceDTO departmentAttendanceStatus (@PathVariable int depart_id) throws ServletException, IOException {
	    logger.info("[ AttendanceController - departmentAttendanceStatus ]");
	    
	    System.out.println("!@!#@!# : " + depart_id);

	    DepAttendanceDTO dto = service.departmentAttendanceStatus(depart_id);
	    
	    return dto;
	}
	
	// 부서별 근태 현황(상세) 조회 (Select)
	@GetMapping("/departmentAtDetails/{depart_id}")
	public DepAttendanceDTO departmentAtDetails (@PathVariable int depart_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - departmentAtDetails ]");
		
		DepAttendanceDTO dto = service.departmentAtDetails(depart_id);
		
		return dto;
	}
	
	// 부서별 근태 통계(상세) 조회 (Select) [ 정렬 ]
	@GetMapping("/departmentAlign/{depart_id}")
	public List<DepAttendanceDTO> departmentAlign (@PathVariable int depart_id, HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("[ AttendanceController - departmentAlign ]");
		
		List<DepAttendanceDTO> dto = service.departmentAlign(req, model, depart_id);
		
		return dto;
	}
	
	// 전사 근태 현황/통계 조회 (Select)
	@GetMapping("/companyStatus")
	public List<ComAttendanceDTO> companyStatus(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("[ AttendanceController - companyStatus ]");
		
		return service.companyStatus(req, model);
	}

}
