package com.example.team_pj_springboot.service;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

public interface GuestService {
	
	// 연차 신청 (insert)
	public void annualInsert (AnnualDTO dto);
	
	// 휴가 신청 (insert)
	public void vacationInsert (VacationDTO dto);
	
	// 나의 근태 현황 1(프로필 오른쪽)[ main 화면 ]
	
	// 나의 근태 현황 2(주간 근무 현황)[ main 화면 ]

	// 나의 근태 현황 (상세)[ 내 근태 현황 상세페이지 ]
	
	// 지각 시간 / 지각 횟수 / 결근 횟수 / 휴가 기간 / 휴가 사유 [ 내 근태 현황 상세페이지 ]
	
	// 나의 연차 현황 [ 내 근태 현황 상세페이지 ]
}
