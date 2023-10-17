package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.rmi.ServerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.personnelMemberDTO;
import com.example.team_pj_springboot.service.PersonnelService;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/personnel") 
public class PersonnelController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonnelController.class);
	
	@Autowired
	private PersonnelService service;
	
	@PostMapping("/employeeInsert")
	public void employeeInsert(@RequestBody personnelMemberDTO dto) 
		throws ServerException, IOException{
		logger.info("[ personnelController - employeeInsert ]");
		
		service.employeeInsert(dto);
	}
	
}
