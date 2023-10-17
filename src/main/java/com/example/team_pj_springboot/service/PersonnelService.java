package com.example.team_pj_springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.personnelMemberDTO;
import com.example.team_pj_springboot.repository.PersonnelRepository;

@Service
public class PersonnelService {
	
	private final PersonnelRepository personnelRepository;
	
	@Autowired
	public PersonnelService(PersonnelRepository personnelRepository) {
		this.personnelRepository = personnelRepository;
	}
	
	@Transactional
	public void employeeInsert(personnelMemberDTO dto) {
		personnelRepository.save(dto);
	}
	
}
