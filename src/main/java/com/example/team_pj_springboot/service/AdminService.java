package com.example.team_pj_springboot.service;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.ComAttendanceDTO;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.TeamAndAttenDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminService {
	
	// 연차 신청 목록 조회
	public List<AnnualDTO> annualRequestsList(HttpServletRequest req, Model model) throws ServletException, IOException;
	
	// 연차 상세페이지
	public AnnualDTO annualDetail(int annual_id) throws ServletException, IOException;
	
	// 연차 상세페이지 승인 및 조회
	public void annualConfirm(int annual_id) throws ServletException, IOException;
	
	// 연차 상세페이지 반려 및 조회
	public void annualReturn(int annual_id) throws ServletException, IOException;
	
	// 휴가 신청 목록 조회
	public List<VacationDTO> vacationRequestsList(HttpServletRequest req, Model model) throws ServletException, IOException;
	
	// 휴가 상세페이지
	public VacationDTO vacationDetail(int vacation_id) throws ServletException, IOException;
	
	// 휴가 상세페이지 승인 및 조회
	public void vacationConfirm(int vacation_id) throws ServletException, IOException;
	
	// 휴가 상세페이지 반려 및 조회
	public void vacationReturn(int vacation_id) throws ServletException, IOException;
	
	// 부서별 근태 현황/통계 조회 (부서 하나)
	public DepAttendanceDTO departmentAttendanceStatus(int depart_id) throws ServletException, IOException;
	
	// 팀별 근태 현황/통계 조회(부서내 팀)
	public TeamAndAttenDTO teamAttendanceStatus(int team_id) throws ServletException, IOException;

	// 부서별 근태 현황(상세) 조회 (부서 하나)
	public DepAttendanceDTO departmentAtDetails(int depart_id) throws ServletException, IOException;
	
	// 부서별 근태 통계(상세) 조회 (부서 하나) ( 정렬 )
	public List<DepAttendanceDTO> departmentAlign(HttpServletRequest req, Model model, int depart_id) throws ServletException, IOException;
	
	// 전사 근태 현황/통계 조회
	public List<ComAttendanceDTO> companyStatus(HttpServletRequest req, Model model, String company_id) throws ServletException, IOException;
	
}
