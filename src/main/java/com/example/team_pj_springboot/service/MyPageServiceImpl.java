package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.MyPageDTO;
import com.example.team_pj_springboot.repository.MemberRepository;
import com.example.team_pj_springboot.repository.MyPageRepository;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageRepository dao;
	
	@Autowired
	private MemberRepository dao1;
	

	@Override
	public List<MyPageDTO> memberFind(String id) {
		
		return dao.findMemeberByMyPageDTO(id);
	}

	@Override
	public void updateMember(MyPageDTO dto) {
		dao.save(dto);
	}
	
	// 마이페이지 진입을 위한 조회
	@Override
	public MemberDTO get(String id) {
		System.out.println("떠라");
		return dao1.findById(id).get();
	}
	
	// 마이페이지 수정
	@Override
	public void save(MemberDTO member) {
		dao1.save(member);
	}
}
