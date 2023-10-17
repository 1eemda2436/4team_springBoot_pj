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
	
	public String findMaxEmployeeId() {
        // JPA 리포지토리를 사용하여 가장 큰 ID를 검색
        return personnelRepository.findMaxId();
    }
	
}
