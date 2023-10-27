package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/admin/department") 
public class DepartmentController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;
	
	//Department select
	@GetMapping("/DepartmentManagement")
	public List<Object[]> departmentManagement () {
		return departmentService.departmentManagement();
	}
	
	//Department insert
	@PostMapping("/DepartmentInsert")
	public void DepartmentInsert(@RequestBody DepartmentDTO dto) {
		
		DepartmentDTO departmentDto = new DepartmentDTO();
		
		departmentDto.setDepart_name(dto.getDepart_name());
		departmentDto.setCompany_id(dto.getCompany_id());
		
		departmentService.DepartmentInsert(departmentDto);
	}
	
	//DepartmentUpdate
	@PutMapping("/DepartmentUpdate")
	public void DepartmentUpdate(@RequestBody DepartmentDTO dto) 
		throws ServletException, IOException {
		
		departmentService.DepartmentUpdate(dto);
	}
	
	//DepartmentDelete-Update show = 'N'
	@PutMapping("/DepartmentDelete/{depart_id}")
	public void DepartmentDelete(@PathVariable int depart_id) {
		departmentService.DepartmentDelete(depart_id);
	}
	
	//company_id 기준 select find id
	@GetMapping("/find/{company_id}")
	public List<DepartmentDTO> departmentFind(@PathVariable String company_id) {
		return departmentService.departmentFind(company_id);
	}
	
	//depart_id 기준 select find id
	@GetMapping("/teamsFind/{depart_id}")
	public List<TeamDTO> teamsFind(@PathVariable int depart_id) {
		System.out.println("!@#" + depart_id);
		return departmentService.teamsFind(depart_id);
	}
	
}