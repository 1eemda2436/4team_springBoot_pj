package com.example.team_pj_springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.MyPageDTO;
import com.example.team_pj_springboot.dto.UserRoleDTO;
import com.example.team_pj_springboot.mappers.PersonnelMapper;
import com.example.team_pj_springboot.repository.MemberRepository;
import com.example.team_pj_springboot.repository.MyPageRepository;
import com.example.team_pj_springboot.repository.UserRoleRepository;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MemberRepository member;
	
	@Autowired
	private PersonnelMapper mapper;
	
	// 마이페이지 진입을 위한 조회
	@Override
	public AllPersonnelDTO get(String id) {
		System.out.println("떠라");
		return mapper.myInfo(id);
	}
	
	// 마이페이지 수정 
	@Transactional
	public void save(MemberDTO dto) {
		System.out.println("수정");
		member.updateMember(dto.getEmail(), dto.getTel(), dto.getBank(), dto.getId());
	}
	
	
}
