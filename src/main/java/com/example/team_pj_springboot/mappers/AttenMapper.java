package com.example.team_pj_springboot.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

@Mapper
public interface AttenMapper {
	
	public int insertAnnual(AnnualDTO dto);				// 연차 글 작성
	
	public void myAnnualModify(AnnualDTO dto);			// 연차 글 수정
	
	public int insertVacation(VacationDTO dto);				// 휴가 글 작성
	
	public void myVacationModify(VacationDTO dto);			// 휴가 글 수정
	
	public AttendanceDTO myAttenCount(String id);		// 총 연차 / 사용 연차 / 잔여 연차 / 지각계 / 결근계 / 조퇴계
	
}
