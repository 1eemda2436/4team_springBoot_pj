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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
import com.example.team_pj_springboot.dto.MyAttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.service.AdminServiceImpl;
import com.example.team_pj_springboot.service.DepAttenService;
import com.example.team_pj_springboot.service.GuestServiceImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping(value = "/guest/attendance")
public class AttendanceGuestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceGuestController.class);
	
	@Autowired
	private GuestServiceImpl gservice;
	
	// 연차 신청 목록(Guest)
	@GetMapping("/annualGuestList/{id}")
	public List<AnnualDTO> annualGuestList (@PathVariable String id, HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - annualGuestList ]");
		
		return gservice.annualGuestList(req, model, id);
	}
	
	// 휴가 신청 목록(Guest)
	@GetMapping("/vacatGuestList/{id}")
	public List<VacationDTO> vacatGuestList (@PathVariable String id, HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ AttendanceController - vacatGuestList ]");
		
		return gservice.vacationGuestList(req, model, id);
	}
	
	// 연차 신청서 작성 (insert)
	@PostMapping("/annualRegister")
	public Map<String, Object> annualRegister (@RequestBody AnnualDTO dto) throws ServletException, IOException {
		System.out.println("[ AttendanceController - annualRegister ]");
		
		System.out.println(dto);
		
		String resultCode = "";
		String resultMsg = "";
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			int annualCnt = gservice.annualInsert(dto);
			if(annualCnt == 1) {
				resultCode = "200";
				resultMsg = "Insert Clear";
			}
			
		} catch (Exception e) {
			resultCode = "400";
			resultMsg = e.getMessage();
			e.printStackTrace();
		}
		map.put("resultCode", resultCode);
		map.put("resultMsg", resultMsg);
		
		return map;
		
	}
	
	// 휴가 신청서 작성 (insert)
	@PostMapping("/vacationRegister")
	public Map<String, Object> vacationRegister (@RequestBody VacationDTO dto) throws ServletException, IOException {
		System.out.println("[ AttendanceController - vacationRegister ]");
		
		String resultCode = "";
		String resultMsg = "";
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			int annualCnt = gservice.vacationInsert(dto);
			if(annualCnt == 1) {
				resultCode = "200";
				resultMsg = "Insert Clear";
			}
			
		} catch (Exception e) {
			resultCode = "400";
			resultMsg = e.getMessage();
			e.printStackTrace();
		}
		map.put("resultCode", resultCode);
		map.put("resultMsg", resultMsg);
		
		return map;
	}
	
	// 연차계 수정 (update)
	@PutMapping("/annualDetail/{annual_id}")
	public void modifyAnnual (@PathVariable int annual_id, @RequestBody AnnualDTO dto) throws ServletException, IOException {
		System.out.println("[ AttendanceController - modifyAnnual ]");
		
		gservice.modifyAnnual(dto);
	}
	
	// 휴가계 수정 (update)
	@PutMapping("/vacationDetail/{vacation_id}")
	public void modifyAnnual (@PathVariable int vacation_id, @RequestBody VacationDTO dto) throws ServletException, IOException {
		System.out.println("[ AttendanceController - modifyAnnual ]");
		
		gservice.modifyVacation(dto);
	}
	
	// 총 연차 / 사용 연차 / 잔여 연차 / 지각계 / 결근계 / 조퇴계
	@GetMapping("/myAttenCount/{id}")
	public MyAttendanceDTO myAttenCount (@PathVariable String id) throws ServletException, IOException {
		System.out.println("[ AttendanceController - myAttenCount ]");
		
		MyAttendanceDTO dto = gservice.myAttenCount(id);
		
		return dto;
	}
	
	// 주간 총 근무시간 / 주간 총 야근 시간 / 남은 총 근무시간
	@GetMapping("/weeklyWorkTime/{id}")
	public MyAttendanceDTO weeklyWorkTime (@PathVariable String id) throws ServletException, IOException {
		System.out.println("[ AttendanceController - weeklyWorkTime ]");
		
		MyAttendanceDTO dto = gservice.weeklyWorkTime(id);
		
		return dto;
	}
	
	// 나의 근태 현황 (상세)[ 내 근태 현황 상세페이지 ]
	@GetMapping("/myWorkDetail/{id}")
	public MyAttendanceDTO myWorkDetail (@PathVariable String id) throws ServletException, IOException {
		System.out.println("[ AttendanceController - myWorkDetail ]");
		
		MyAttendanceDTO dto = gservice.myWorkDetail(id);
		
		return dto;
	}
	
	// 나의 근태 현황 (상세) [ 총연차 / 사용연차 / 잔여연차 ]
	@GetMapping("/myCurrentAnnual/{id}")
	public MyAttendanceDTO myCurrentAnnual (@PathVariable String id) throws ServletException, IOException {
		System.out.println("[ AttendanceController - myCurrentAnnual ]");
		
		MyAttendanceDTO dto = gservice.myCurrentAnnual(id);
		
		return dto;
	}
	
	// 휴가계 정보 [ 휴가계(제목) / 휴가 시작 / 휴가 종료 / 휴가 기간 / 휴가 사유(제목) ]  [ 내 근태 현황 상세페이지 ]
	@GetMapping("/myVacationPre/{id}")
	public MyAttendanceDTO myVacationPre (@PathVariable String id) throws ServletException, IOException {
		System.out.println("[ AttendanceController - myVacationPre ]");
		
		MyAttendanceDTO dto = gservice.myVacationPre(id);
		System.out.println(dto);
		return dto;
	}

}
