package com.example.team_pj_springboot.service;

import java.io.IOException;

import javax.servlet.ServletException;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

public interface GuestService {
	
	// 연차 신청 (insert)
	public int annualInsert (AnnualDTO dto) throws ServletException, IOException;
	
	// 작성한 연차 수정(update)
	public void modifyAnnual (AnnualDTO dto) throws ServletException, IOException;
	
	// 휴가 신청 (insert)
	public int vacationInsert (VacationDTO dto) throws ServletException, IOException;
	
	// 작성한 휴가 수정(update)
	public void modifyVacation (VacationDTO dto) throws ServletException, IOException;
	
	// 총 연차 / 사용 연차 / 잔여 연차 / 지각계 / 결근계 / 조퇴계
	public AttendanceDTO myAttenCount (String id) throws ServletException, IOException;
	
	// 나의 근태 현황 1(프로필 오른쪽)[ main 화면 ]
	
	// 나의 근태 현황 2(주간 근무 현황)[ main 화면 ]

	// 나의 근태 현황 (상세)[ 내 근태 현황 상세페이지 ]
	
	// 지각 시간 / 지각 횟수 / 결근 횟수 / 휴가 기간 / 휴가 사유 [ 내 근태 현황 상세페이지 ]
	
	// 나의 연차 현황 [ 내 근태 현황 상세페이지 ]
}
