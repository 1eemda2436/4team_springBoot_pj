package com.example.team_pj_springboot.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
import com.example.team_pj_springboot.dto.MyAttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.mappers.AttenMapper;

@Service
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private AttenMapper dao;

	// 연차계 신청
	@Override
	public int annualInsert(AnnualDTO dto) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - annualInsert ]");
		
		int annualCnt = dao.insertAnnual(dto);
		
		return annualCnt;
	}
	
	// 휴가계 신청
	@Override
	public int vacationInsert(VacationDTO dto) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - vacationInsert ]");
		
		int vacatCnt = dao.insertVacation(dto);
		
		return vacatCnt;
	}
	
	// 연차계 수정
	@Override
	public void modifyAnnual(AnnualDTO dto) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - modifyAnnual ]");
		
		dao.myAnnualModify(dto);
	}	

	// 휴가계 수정
	@Override
	public void modifyVacation(VacationDTO dto) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - modifyVacation ]");
		
		dao.myVacationModify(dto);
	}

	// 총 연차 / 사용 연차 / 잔여 연차 / 지각계 / 결근계 / 조퇴계
	@Override
	public MyAttendanceDTO myAttenCount(String id) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - myAttenCount ]");
		
		MyAttendanceDTO AtDto = new MyAttendanceDTO();
		
		AtDto = dao.myAttenCount(id);
		
		System.out.println("AtDto : " + AtDto);
		
		return AtDto;
	}

	// 주간 총 근무시간 / 주간 총 야근 시간 / 남은 총 근무시간
	@Override
	public MyAttendanceDTO weeklyWorkTime(String id) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - weeklyWorkTime ]");
		
		MyAttendanceDTO WeekDto = new MyAttendanceDTO();
		
		WeekDto = dao.weeklyWorkTime(id);
		
		System.out.println("WeekDto : " + WeekDto);
		
		return WeekDto;
	}

	// 나의 근태 현황 (상세)[ 내 근태 현황 상세페이지 ]
	@Override
	public MyAttendanceDTO myWorkDetail(String id) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - myWorkDetail ]");
		
		MyAttendanceDTO myWorkDto = new MyAttendanceDTO();
		
		myWorkDto = dao.myWorkDetail(id);
		
		System.out.println("myWorkDto : " + myWorkDto);
		
		return myWorkDto;
	}

	// 나의 근태 현황 (상세) [ 총연차 / 사용연차 / 잔여연차 ]
	@Override
	public MyAttendanceDTO myCurrentAnnual(String id) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - myCurrentAnnual ]");
		
		MyAttendanceDTO myCrDto = new MyAttendanceDTO();
		
		myCrDto = dao.myCurrentAnnual(id);
		
		System.out.println("myCrDto : " + myCrDto);
		
		return myCrDto;
	}

	// 휴가계 정보 [ 휴가계(제목) / 휴가 시작 / 휴가 종료 / 휴가 기간 / 휴가 사유(제목) ]  [ 내 근태 현황 상세페이지 ]
	@Override
	public MyAttendanceDTO myVacationPre(String id) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - myCurrentAnnual ]");
		
		MyAttendanceDTO myVcDto = new MyAttendanceDTO();
		
		myVcDto = dao.myVacationPre(id);
		
		return myVcDto;
	}
	
	
}
