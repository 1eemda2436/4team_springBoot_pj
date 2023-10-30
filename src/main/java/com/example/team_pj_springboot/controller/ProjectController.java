package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.ProjectDTO;
import com.example.team_pj_springboot.service.ProjectServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/project")
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectServiceImpl service;
	
	// 프로젝트 리스트
	@GetMapping("/list/{team_id}")
	public List<ProjectDTO> ProjectList(@PathVariable(name="team_id")int team_id)
			throws ServerException, IOException {
		
		return service.listAll(team_id);
	}
	
	// 프로젝트 생성
	@PostMapping
	public void save(@RequestBody ProjectDTO dto) 
			throws ServerException, IOException {
		
		System.out.println(dto);
		service.save(dto);
	}
	
	// 프로젝트 수정을 위한 조회
	@GetMapping("/{pj_id}")
	public ProjectDTO fetchProjectById(@PathVariable(name="pj_id")int pj_id) 
			throws ServerException, IOException {
		
		ProjectDTO dto = service.get(pj_id);
		return dto;

	}
	
	// 프로젝트 삭제
	@DeleteMapping("/{pj_id}")
	public void ProjectWorkDelete(@PathVariable(name="pj_id") int pj_id) 
			throws ServerException, IOException {
		
		service.delete(pj_id);
	}

	
	

}
