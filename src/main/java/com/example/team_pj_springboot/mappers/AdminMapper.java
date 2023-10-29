package com.example.team_pj_springboot.mappers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.ComAnnualListDTO;
import com.example.team_pj_springboot.dto.ComAttendanceDTO;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.TeamAndAttenDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

@Mapper
public interface AdminMapper {
	
	public List<AnnualDTO> annualRequestsList(String company_id);	// 신청된 연차 목록
	
	public AnnualDTO annualDetail(int annual_id);	// 연차 글 상세페이지
	
	public void confirmAnnual(int annual_id);		// 연차 승인
	public void returnAnnual(int annual_id);		// 연차 반려
	
	public List<VacationDTO> vacationRequestsList(String company_id);	// 신청된 휴가 목록
	
	public VacationDTO vacationDetail(int vacation_id);	// 휴가 글 상세페이지
	
	public void confirmVacation(int vacation_id);		// 휴가 승인
	public void returnVacation(int vacation_id);		// 휴가 반려
	
	public DepAttendanceDTO departmentAttendanceStatus(int depart_id);	// 부서별 근태 현황/통계 조회 (부서 하나)
	public TeamAndAttenDTO teamAttendanceStatus(int team_id);		// 팀별 근태 현황/통계조회(원형그래프)
	
	public DepAttendanceDTO departmentAtPercent(int depart_id);	// 부서별 근태 현황(상세)[ 출근/지각/연차 률, 지각자/연차 및 휴가자 수 ]
//	public DepartmentDTO departmentAtCal(int depart_id);		// 부서별 근태 현황 [ 캘린더 ]
	
	public List<DepAttendanceDTO> departmentAlign(int depart_id);	// 부서별 근태 통계(상세) [ 이름순 / 지각순 	/ 사번순 / 정렬기능 ]
	
	public List<ComAttendanceDTO> companyStatus(String company_id);					// 전사 근태 현황/통계

}
