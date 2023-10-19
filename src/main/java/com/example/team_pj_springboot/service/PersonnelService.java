package com.example.team_pj_springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.SalaryDTO;
import com.example.team_pj_springboot.dto.personnelMemberDTO;
import com.example.team_pj_springboot.mappers.PersonnelMapper;
import com.example.team_pj_springboot.repository.PersonnelRepository;
import com.example.team_pj_springboot.repository.SalaryRepository;

@Service
public class PersonnelService {
	
	private final PersonnelRepository personnelRepository;
	private final SalaryRepository salaryRepository;
	
	@Autowired
	private PersonnelMapper mapper;
	
	@Autowired
	public PersonnelService(
			PersonnelRepository personnelRepository,
			SalaryRepository salaryRepository) {
		this.personnelRepository = personnelRepository;
		this.salaryRepository = salaryRepository;
	}
	
	@Transactional
	public void employeeInsert(personnelMemberDTO dto) {
		personnelRepository.save(dto);
	}
	
	//월급 초기값
	@Transactional
    public SalaryDTO saveSalary(personnelMemberDTO dto) {
		
		SalaryDTO sadto = new SalaryDTO();
		sadto.setId(dto.getId());
		
		SalaryDTO saveSalary = salaryRepository.save(sadto);
		
    	return saveSalary;
    }
	
	public int findMaxEmployeeId() {
		System.out.println("서비스 - findMaxEmployeeId ");
        // JPA 리포지토리를 사용하여 가장 큰 ID를 검색
        return mapper.findMaxId();
    }
	
}
