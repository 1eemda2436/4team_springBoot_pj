package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.team_pj_springboot.mappers.AdminMapper;
import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.ComAttendanceDTO;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper dao;

	// 연차 신청 목록 조회
	@Override
	public List<AnnualDTO> annualRequestsList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → annualRequestsList ]");
		
		List<AnnualDTO> AnnualList = dao.annualRequestsList();
		
		System.out.println("Annuallist : " + AnnualList);
		
		return AnnualList;
	}
	
	// 연차 상세페이지 조회
	@Override
	public AnnualDTO annualDetail(int annual_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → annualDetail ]");
		
		AnnualDTO AnDto = dao.annualDetail(annual_id);
		
		System.out.println("AnDto : " + AnDto);
		
		return AnDto;
	}

	// 연차 상세페이지 승인 및 조회
	@Override
	public void annualConfirm(int annual_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → annualConfirm ]");
		
		dao.confirmAnnual(annual_id);
	}

	// 연차 상세페이지 반려 및 조회
	@Override
	public void annualReturn(int annual_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → annualReturn ]");
		
		dao.returnAnnual(annual_id);
	}
	
	// 휴가 신청 목록 조회
	@Override
	public List<VacationDTO> vacationRequestsList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → vacationRequestsList ]");
		
		List<VacationDTO> VacationList = dao.vacationRequestsList();
		
		System.out.println("VacationList : " + VacationList);
		
		return VacationList;
	}

	// 휴가 상세페이지
	@Override
	public VacationDTO vacationDetail(int vacation_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → vacationDetail ]");
		
		VacationDTO VcDto = dao.vacationDetail(vacation_id);
		
		System.out.println("VcDto : " + VcDto);
		
		return VcDto;
	}

	// 휴가 상세페이지 승인 및 조회
	@Override
	public void vacationConfirm(int vacation_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → vacationConfirm ]");
		
		dao.confirmVacation(vacation_id);
	}

	// 휴가 상세페이지 반려 및 조회
	@Override
	public void vacationReturn(int vacation_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → vacationReturn ]");
		
		dao.returnVacation(vacation_id);
	}
	
	// 부서별 근태 현황/통계 조회 (부서 하나)
	@Override
	public DepAttendanceDTO departmentAttendanceStatus(int depart_id)
			throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → departmentAttendanceStatus ]");
		
		DepAttendanceDTO DepDTO = dao.departmentAttendanceStatus(depart_id);
		
		System.out.println("DepDTO : " + DepDTO);
		
		return DepDTO;
	}

	// 부서별 근태 현황(상세) 조회 (부서 하나)	[ 출근/지각/연차 률 ]
	@Override
	public DepAttendanceDTO departmentAtDetails(int depart_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → departmentAtDetails ]");
		
		DepAttendanceDTO AtDto = new DepAttendanceDTO();
		AtDto = dao.departmentAtPercent(depart_id);
		
		System.out.println("AtDto : " + AtDto);
		
		return AtDto;
	}

	// 부서별 근태 통계(상세) 조회 (부서 하나) [ 정렬 ]
	@Override
	public List<DepAttendanceDTO> departmentAlign(HttpServletRequest req, Model model, int depart_id) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → departmentStDetails ]");
		
		List<DepAttendanceDTO> StDto = dao.departmentAlign(depart_id);
		
		System.out.println("StDto : " + StDto);
		
		return StDto;
	}

	// 전사 근태 현황/통계 조회
	@Override
	public List<ComAttendanceDTO> companyStatus(HttpServletRequest req, Model model) throws ServletException, IOException {
		System.out.println("[ AnnualServiceImpl → companyStatus ]");
		
		List<ComAttendanceDTO> ComDto = dao.companyStatus();
		
		System.out.println("ComDto : " + ComDto);
		
		return ComDto;
	}



}
