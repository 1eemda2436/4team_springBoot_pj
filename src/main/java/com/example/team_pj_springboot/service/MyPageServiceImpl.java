package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.MyPageDTO;
import com.example.team_pj_springboot.repository.MyPageRepository;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageRepository dao;
	

	@Override
	public List<MyPageDTO> memberFind(String id) {
		
		return dao.findMemeberByMyPageDTO(id);
	}

	@Override
	public void updateMember(MyPageDTO dto) {
		dao.save(dto);
	}
}
