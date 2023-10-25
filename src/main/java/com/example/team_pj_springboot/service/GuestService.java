package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
import com.example.team_pj_springboot.dto.MyAttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

public interface GuestService {
	
	// 연차 신청 목록 조회
	public List<AnnualDTO> annualGuestList(HttpServletRequest req, Model model, String id) throws ServletException, IOException;
	
	// 휴가 신청 목록 조회
	public List<VacationDTO> vacationGuestList(HttpServletRequest req, Model model, String id) throws ServletException, IOException;
	
	// 연차 신청 (insert)
	public int annualInsert (AnnualDTO dto) throws ServletException, IOException;
	
	// 작성한 연차 수정(update)
	public void modifyAnnual (AnnualDTO dto) throws ServletException, IOException;
	
	// 휴가 신청 (insert)
	public int vacationInsert (VacationDTO dto) throws ServletException, IOException;
	
	// 작성한 휴가 수정(update)
	public void modifyVacation (VacationDTO dto) throws ServletException, IOException;
	
	// 총 연차 / 사용 연차 / 잔여 연차 / 지각계 / 결근계 / 조퇴계
	public MyAttendanceDTO myAttenCount (String id) throws ServletException, IOException;
	
	// 주간 총 근무시간 / 주간 총 야근 시간 / 남은 총 근무시간
	public MyAttendanceDTO weeklyWorkTime (String id) throws ServletException, IOException;

	// 나의 근태 현황 (상세)[ 내 근태 현황 상세페이지 ]
	public MyAttendanceDTO myWorkDetail (String id) throws ServletException, IOException;
	
	// 나의 근태 현황 (상세) [ 총연차 / 사용연차 / 잔여연차 ]
	public MyAttendanceDTO myCurrentAnnual (String id) throws ServletException, IOException;
	
	// 휴가계 정보 [ 휴가계(제목) / 휴가 시작 / 휴가 종료 / 휴가 기간 / 휴가 사유(제목) ]  [ 내 근태 현황 상세페이지 ]
	public MyAttendanceDTO myVacationPre (String id) throws ServletException, IOException;
	
	// 승인된 연차 목록
	public List<AnnualDTO> confirmAnnualLs (HttpServletRequest req, Model model) throws ServletException, IOException;
	
	// 승인된 연차 목록
	public List<VacationDTO> confirmVacaLs (HttpServletRequest req, Model model) throws ServletException, IOException;
}
