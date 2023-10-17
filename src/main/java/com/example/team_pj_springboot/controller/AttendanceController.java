package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.service.AnnualServiceImpl;
import com.example.team_pj_springboot.service.DepAttenService;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	private AnnualServiceImpl service;
	private DepAttenService depservice;
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////// ADMIN ///////////////////////////////
	/////////////////////////////////////////////////////////////////////
	
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
		
		AnnualDTO dto = service.annualDetail(annual_id);
		
		return dto;
	}
	
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
	
	//////////////////////////////////////////////////////////////////////
	
	// 휴가 신청 목록 조회 (Select)
	@GetMapping("/vacationRequestsList")
	public List<VacationDTO> vacationRequestsList (HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - vacationRequestsList ]");
		
		return service.vacationRequestsList(req, model);
	}
	
	// 휴가 상세 페이지 (Select)
	@GetMapping("/vacationDetail/{vacation_id}")
	public VacationDTO vacationDetail (@PathVariable int vacation_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - vacationDetail ]");
		
		return service.vacationDetail(vacation_id);
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
	
	//////////////////////////////////////////////////////////////////////
	
//	// 부서별 근태 현황/통계 조회 (Select)
//	@GetMapping("/departmentAttendanceStatus/{depart_id}")
//	public Optional<DepAttendanceDTO> departmentAttendanceStatus (@PathVariable int depart_id) {
//	    logger.info("[ AttendanceController - departmentAttendanceStatus ]");
//	    
//	    System.out.println("!@!#@!# : " + depart_id);
//
//	    Optional<DepAttendanceDTO> dto = depservice.departmentAttendanceStatus(depart_id);
//	    
//	    return dto;
//	}
	
//	// 부서별 근태 현황(상세) 조회 (Select)
//	@GetMapping("/departmentAtDetails/{depart_id}")
//	public DepartmentDTO departmentAtDetails (@PathVariable int depart_id) throws ServletException, IOException {
//		logger.info("[ AttendanceController - departmentAtDetails ]");
//		
//		return service.departmentAtDetails(depart_id);
//	}
//	
//	// 부서별 근태 통계(상세) 조회 (Select)
//	@GetMapping("/departmentStDetails/{depart_id}")
//	public DepartmentDTO departmentStDetails (@PathVariable int depart_id) throws ServletException, IOException {
//		logger.info("[ AttendanceController - departmentStDetails ]");
//		
//		return service.departmentStDetails(depart_id);
//	}
//	
//	// 전사 근태 현황/통계 조회 (Select)
//	@GetMapping("/companyStatus")
//	public List<CompanyDTO> companyStatus(HttpServletRequest req, Model model) throws ServletException, IOException {
//		logger.info("[ AttendanceController - companyStatus ]");
//		
//		return service.companyStatus(req, model);
//	}
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////// GUEST ///////////////////////////////
	/////////////////////////////////////////////////////////////////////
	
}
