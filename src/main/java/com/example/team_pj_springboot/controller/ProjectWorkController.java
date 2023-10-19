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

import com.example.team_pj_springboot.dto.ProjectWorkDTO;
import com.example.team_pj_springboot.service.ProjectWorkServiceImpl;

@CrossOrigin(origins="**", maxAge=3600)
@RestController
@RequestMapping(value="/guest/projectwork") //공통경로
public class ProjectWorkController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectWorkController.class);
	
	@Autowired
	private ProjectWorkServiceImpl service;
	
	// 프로젝트 업무 리스트
	@GetMapping
	public List<ProjectWorkDTO> ProjectWorkList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		logger.info("[ url - ProjectWorkList ]");
		
		return service.listAll(req, model);
	}
	
	// 프로젝트 업무 생성 또는 수정application/j
	@PostMapping
	public void ProjectWorkInsert(@RequestBody ProjectWorkDTO dto)
			throws ServletException, IOException {
		logger.info("[ url - ProjectWorkInsert ]");
		
		service.save(dto);
	}
	
	// 프로젝트 업무 수정을 위한 조회
	@GetMapping("/{pw_id}")
	public ProjectWorkDTO fetchProjectWorkById(@PathVariable(name="pw_id")int pw_id, Model model)
			throws ServletException, IOException {
		logger.info("[ url - fetchProjectWorkById ]");
		
		ProjectWorkDTO dto = service.get(pw_id);
		return dto;
	}
	
	// 프로젝트 업무 삭제
	@DeleteMapping("/{pw_id}")
	public void ProjectWorkDelete(@PathVariable(name="pw_id") int pw_id, Model model) 
			throws ServletException, IOException {
		logger.info("[ url - ProjectWorkDelete ]");
		
		service.delete(pw_id);
	}
	
}
