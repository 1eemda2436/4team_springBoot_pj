package com.example.team_pj_springboot.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
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
	public AttendanceDTO myAttenCount(String id) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - myAttenCount ]");
		
		AttendanceDTO AtDto = new AttendanceDTO();
		
		AtDto = dao.myAttenCount(id);
		
		System.out.println("AtDto : " + AtDto);
		
		return AtDto;
	}
	
	
}
