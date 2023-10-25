package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.PersonnelMemberDTO;
import com.example.team_pj_springboot.service.PersonnelService;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/admin/personnel") 
public class PersonnelController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonnelController.class);
	
	@Autowired
	private PersonnelService service;
	
	//Employee Insert
	@PostMapping("/employeeInsert")
	public void employeeInsert(@RequestBody PersonnelMemberDTO dto) 
		throws ServerException, IOException{
		logger.info("[ personnelController - employeeInsert ]");
		
		service.employeeInsert(dto);
		service.saveSalary(dto);
	}
	
	//String ID maxID 찾기
	@GetMapping("/maxId")
    public String findMaxEmployeeId() {
		logger.info("[ personnelController - findMaxEmployeeId ]");
		
		String sid = String.valueOf(service.findMaxEmployeeId());
        return sid;
    }
	
	//Employee Select all
	@GetMapping("/employeeSelectAll/{company_id}")
	public List<AllPersonnelDTO> selectAllEmployee(@PathVariable String company_id){
		logger.info("[ personnelController - selectEmployee ]");
		
		return service.selectAllEmployee(company_id);
	}
	
	//Employee Select One
	@GetMapping("/EmployeeModification/{id}")
	public Optional<PersonnelMemberDTO> selectEmployee(@PathVariable String id){
		logger.info("[ personnelController - selectEmployee ]");
		
		Optional<PersonnelMemberDTO> dto = service.selectEmployee(id);
		return dto;
	}
	
	//Employee Update
	@PutMapping("/EmployeeUpdate/{id}")
	public void employeeUpdate(@PathVariable String id, @RequestBody PersonnelMemberDTO dto) {
		
		service.employeeUpdate(dto);
	}
	
	//Employee Delete
	@DeleteMapping("/delete/{id}")
	public void employeeDelete(@PathVariable String id) {
		service.employeeDelete(id);
	}
	
}
