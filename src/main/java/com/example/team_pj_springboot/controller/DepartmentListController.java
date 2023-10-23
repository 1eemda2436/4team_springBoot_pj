package com.example.team_pj_springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.DepartmentListDTO;
import com.example.team_pj_springboot.service.DepartmentListServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/department")
public class DepartmentListController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private DepartmentListServiceImpl service;
	
	//부서별 사원 리스트
	@GetMapping
	public List<DepartmentListDTO> DepartList() {
		logger.info("[ url - DepartList]");
		
		return service.listAll();
	}
}
