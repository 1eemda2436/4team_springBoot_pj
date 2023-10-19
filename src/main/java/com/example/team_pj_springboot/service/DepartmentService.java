package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//Department select
	public List<Object[]> departmentManagement () {
		return departmentRepository.findDepartmentsWithTeamCount();
	}
}
