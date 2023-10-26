package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.AttendanceDTO;
import com.example.team_pj_springboot.dto.MyAttendanceDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

@Mapper
public interface AttenMapper {
	
	public List<AnnualDTO> annualGuestList(String id);		// 신청된 연차 목록(Guest)
	
	public List<VacationDTO> vacationGuestList(String id);	// 신청된 휴가 목록(Guest)
	
	public int insertAnnual(AnnualDTO dto);					// 연차 글 작성
	
	public void myAnnualModify(AnnualDTO dto);				// 연차 글 수정
	
	public int insertVacation(VacationDTO dto);				// 휴가 글 작성
	
	public void myVacationModify(VacationDTO dto);			// 휴가 글 수정
	
	public MyAttendanceDTO myAttenCount(String id);			// 총 연차 / 사용 연차 / 잔여 연차 / 지각계 / 결근계 / 조퇴계
	
	public MyAttendanceDTO weeklyWorkTime(String id);		// 주간 총 근무시간 / 주간 총 야근 시간 / 남은 총 근무시간
	
	public MyAttendanceDTO myWorkDetail(String id);			// 나의 근태 현황 ( 사원번호 ~ 총 근무시간 )
	
	public MyAttendanceDTO myCurrentAnnual(String id);		// 나의 근태 현황 (상세) [ 총연차 / 사용연차 / 잔여연차 ]
	
	public MyAttendanceDTO myVacationPre(String id);		// 휴가계 정보 [ 휴가계(제목) / 휴가 시작 / 휴가 종료 / 휴가 기간 / 휴가 사유(제목) ] 
	
	public List<AnnualDTO> anComfirmList();					// 승인된 연차 
	
	public List<VacationDTO> vaComfirmList();					// 승인된 휴가
	
}
