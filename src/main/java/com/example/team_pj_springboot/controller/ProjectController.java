package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	@GetMapping
	public List<ProjectDTO> ProjectList(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		logger.info("[ url - ProjectList ]");
		
		return service.listAll(req, model);
	}
	
	// 프로젝트 생성 또는 수정
	@PostMapping
	public void ProjectInsert(@RequestBody ProjectDTO dto)
			throws ServletException, IOException {
		logger.info("[ url - ProjectInsert ]");

		service.save(dto);
	}
	
	// 프로젝트 수정을 위한 조회
	@GetMapping("/{pj_id}")
	public ProjectDTO fetchProjectById(@PathVariable(name="pj_id")int pj_id, Model model) 
			throws ServletException, IOException {
		logger.info("[ url - fetchProjectById ]");
		
		ProjectDTO dto = service.get(pj_id);
		return dto;

		
	}
	
	// 프로젝트 삭제
	@DeleteMapping("/{pj_id}")
	public void ProjectDelete(@PathVariable(name="pj_id") int pj_id, Model model) 
			throws ServletException, IOException {
		logger.info("[ url - ProjectDelete ]");
		
		service.delete(pj_id);
	}
	
	
	

}
