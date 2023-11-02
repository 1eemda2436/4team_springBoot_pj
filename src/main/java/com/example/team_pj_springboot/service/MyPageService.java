package com.example.team_pj_springboot.service;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.MemberDTO;

public interface MyPageService {
	
	// 마이페이지 진입을 위한 조회
	public AllPersonnelDTO get(String id);
	
	// 마이페이지 수정
	public void save(MemberDTO dto);

	
	
}
