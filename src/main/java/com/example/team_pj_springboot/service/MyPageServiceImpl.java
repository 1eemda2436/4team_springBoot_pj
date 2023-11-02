package com.example.team_pj_springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.mappers.PersonnelMapper;
import com.example.team_pj_springboot.repository.MemberRepository;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MemberRepository member;
	
	@Autowired
	private PersonnelMapper mapper;
	
	@Override
	public AllPersonnelDTO get(String id) {
		return mapper.myInfo(id);
	}
	
	@Transactional
	public void save(MemberDTO dto) {
		member.updateMember(dto);
	}
	
	
}
