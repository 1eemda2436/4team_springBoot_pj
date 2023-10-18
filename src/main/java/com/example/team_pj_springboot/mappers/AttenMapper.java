package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.VacationDTO;

@Mapper
public interface AttenMapper {
	
	public int insertAnnual(AnnualDTO dto);				// 연차 글 작성
	
	public List<AnnualDTO> annualRequiredList();		// 신청한 연차 목록
	
	public AnnualDTO myAnnualDetail(int annual_id);		// 연차 글 상세페이지
	
	public void myAnnualModify(int annual_id);			// 연차 글 수정
	
	public int insertVacation(VacationDTO dto);				// 연차 글 작성
	
	public List<VacationDTO> vacationRequiredList();		// 신청한 연차 목록
	
	public VacationDTO myVacationDetail(int vacation_id);		// 연차 글 상세페이지
	
	public void myVacationModify(int vacation_id);			// 연차 글 수정

}
