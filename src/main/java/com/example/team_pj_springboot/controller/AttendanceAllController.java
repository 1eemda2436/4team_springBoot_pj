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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.ComAnnualListDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.service.AdminServiceImpl;
import com.example.team_pj_springboot.service.GuestServiceImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping(value = "/all/attendance")
@RequiredArgsConstructor
public class AttendanceAllController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceAllController.class);
	
	@Autowired
	private AdminServiceImpl service;
	
	@Autowired 
	private GuestServiceImpl gservice;
	
	// 연차 신청 목록 조회 (Select)
	@GetMapping("/annualRequestsList/{company_id}")
	public List<AnnualDTO> annualRequestsList (@PathVariable String company_id, HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualRequestsList ]");
		
		return service.annualRequestsList(req, model, company_id);
	}
	
	// 연차 상세 페이지 (Select)
	@GetMapping("/annualDetail/{annual_id}")
	public AnnualDTO annualDetail (@PathVariable int annual_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - annualDetail ]");
		
		AnnualDTO dto = service.annualDetail(annual_id);
		
		return dto;
	}
	
	// 휴가 신청 목록 조회 (Select)
	@GetMapping("/vacationRequestsList/{company_id}")
	public List<VacationDTO> vacationRequestsList (@PathVariable String company_id, HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - vacationRequestsList ]");
		
		return service.vacationRequestsList(req, model, company_id);
	}
	
	// 휴가 상세 페이지 (Select)
	@GetMapping("/vacationDetail/{vacation_id}")
	public VacationDTO vacationDetail (@PathVariable int vacation_id) throws ServletException, IOException {
		logger.info("[ AttendanceController - vacationDetail ]");
		
		return service.vacationDetail(vacation_id);
	}
	
	// 승인된 연차 목록
	@GetMapping("/anConfirmList")
	public List<AnnualDTO> anConfirmList (HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("[ AttendanceController - anConfirmList ]");
		
		return gservice.confirmAnnualLs(req, model);
	}
	
	// 승인된 휴가 목록
	@GetMapping("/vaConfirmList")
	public List<VacationDTO> vaConfirmList (HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("[ AttendanceController - vaConfirmList ]");
		
		return gservice.confirmVacaLs(req, model);
	}

}
