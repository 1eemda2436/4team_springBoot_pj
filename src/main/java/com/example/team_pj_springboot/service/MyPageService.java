package com.example.team_pj_springboot.service;

import java.util.List;

import com.example.team_pj_springboot.dto.MyPageDTO;

public interface MyPageService {

	public List<MyPageDTO> memberFind(String id);
	public void updateMember(MyPageDTO dto);
}
