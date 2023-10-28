package com.example.team_pj_springboot.service;

import java.util.List;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.MyPageDTO;

public interface MyPageService {

//	public MyPageDTO memberFind(String id);
//	
//	public void updateMember(MyPageDTO dto);
	
	/*******************유진**********************/
	
	// 마이페이지 진입을 위한 조회
	public AllPersonnelDTO get(String id);
	
	// 마이페이지 수정
	public void save(MemberDTO dto);
	
	
}
