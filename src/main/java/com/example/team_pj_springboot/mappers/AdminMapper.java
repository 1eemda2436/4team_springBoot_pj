package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;

@Mapper
public interface AdminMapper {
	
	public List<AnnualDTO> annualRequestsList();	// 신청된 연차 목록
	
	public AnnualDTO annualDetail(int annual_id);	// 연차 글 상세페이지
	
	public void confirmAnnual(AnnualDTO dto);		// 연차 승인
	public void returnAnnual(AnnualDTO dto);		// 연차 반려
	
	public DepartmentDTO departmentAttendanceStatus(int depart_id);	// 부서별 근태 현황/통계 조회 (부서 하나)
	
	public DepartmentDTO departmentAtPercent(int depart_id);	// 부서별 근태 현황(상세)[ 출근/지각/연차 률 ]
	public DepartmentDTO departmentAtCount(int depart_id);		// 부서별 근태 현황(상세)[ 지각자 수 / 통계 , 연차 및 휴가자 수 / 통계 ]
	public DepartmentDTO departmentAtCal(int depart_id);		// 부서별 근태 현황 [ 캘린더 ]
	
	public DepartmentDTO departmentStDetails(int depart_id);	// 부서별 근태 통계(상세) [ 이름순 / 지각순 	/ 사번순 / 정렬기능 ]
	
	public List<CompanyDTO> companyStatus();					// 전사 근태 현황/통계

}
