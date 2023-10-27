package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.PersonnelMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;
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
	
	//Employee Insert
	@Transactional
	public void employeeInsert(PersonnelMemberDTO dto) {
		personnelRepository.save(dto);
	}
	
	//Salary Initial Data
	@Transactional
    public SalaryDTO saveSalary(PersonnelMemberDTO dto) {
		
		SalaryDTO sadto = new SalaryDTO();
		sadto.setId(dto.getId());
		
		SalaryDTO saveSalary = salaryRepository.save(sadto);
		
    	return saveSalary;
    }
	//ID MAX Value Find
	public int findMaxEmployeeId() {
        // JPA 리포지토리를 사용하여 가장 큰 ID를 검색
        return mapper.findMaxId();
    }
	
	//Employee Select-All///////////////////////////////////////////
	public List<AllPersonnelDTO> selectAllEmployee(String company_id){
		return mapper.findPersonnelMembersWithDetails(company_id);
	}
	
	//Employee Select-One
	@Transactional
	public Optional<PersonnelMemberDTO> selectEmployee (String id){
		return personnelRepository.findById(id);
	}
	
	//Employee Update
	@Transactional
	public void employeeUpdate(PersonnelMemberDTO dto) {
		personnelRepository.updatePersonnel(dto.getId(),dto.getDepart_id(),dto.getTeam_id(),dto.getName(),dto.getTel());
	}
	
	//Employee Delete
	public void employeeDelete(String id) {
		personnelRepository.deleteById(id);
	}
	
}
