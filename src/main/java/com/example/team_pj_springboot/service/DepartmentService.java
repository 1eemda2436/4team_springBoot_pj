package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.repository.DepartmentRepository;
import com.example.team_pj_springboot.repository.TeamRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	//Department select
	public List<Object[]> departmentManagement () {
		return departmentRepository.findDepartmentsWithTeamCount();
	}
	
	//Department insert
	public void DepartmentInsert(DepartmentDTO dto) {
		System.out.println(dto);
		DepartmentDTO departmentDTO = departmentRepository.save(dto);
		
		// 기본 팀 추가
        TeamDTO defaultTeam = new TeamDTO();
        defaultTeam.setDepart_id(departmentDTO.getDepart_id());
        teamRepository.save(defaultTeam);
		
	}

	//Department Update
	public void DepartmentUpdate(DepartmentDTO dto) {
		departmentRepository.save(dto);
	}
	
	//DepartmentDelete-Update show = 'N'
	public void DepartmentDelete(int depart_id) {
		departmentRepository.DepartmentDeleteQuery(depart_id);
	}
	
	//company_id 기준 select find id
	public Optional<DepartmentDTO> departmentFind(String company_id) {
		return departmentRepository.findByCompany_id(company_id);
	}
	
	//company_id 기준 select find id
	public List<TeamDTO> teamsFind(int company_id) {
		return teamRepository.findTeamsByDepartId(company_id);
	}
}
