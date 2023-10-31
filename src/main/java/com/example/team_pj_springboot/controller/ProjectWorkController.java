package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.rmi.ServerException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.ProjectProgressBarDTO;
import com.example.team_pj_springboot.dto.ProjectWorkDTO;
import com.example.team_pj_springboot.service.ProjectWorkServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/projectwork")
public class ProjectWorkController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectWorkController.class);
	
	@Autowired
	private ProjectWorkServiceImpl service;
	
	// 프로젝트 업무 리스트
	@GetMapping("/list/{pj_id}")
	public List<ProjectWorkDTO> ProjectWorkList(@PathVariable(name="pj_id")int pj_id)
			throws ServerException, IOException {
		
		return service.list(pj_id);
	}
	
	// 프로젝트 업무 생성 또는 수정
	@PostMapping("/workadd")
	public void ProjectWorkSave(@RequestBody ProjectWorkDTO dto)
			throws ServerException, IOException {
		
		service.save(dto);
	}
	
	// 프로젝트 업무 complete 여부 업데이트
	@PutMapping("/complete/{pw_id}")
	public void ProjectWorkComplete(@PathVariable(name="pw_id")int pw_id, @RequestBody String complete)
			throws ServerException, IOException {
		service.saveComplete(pw_id, complete);
	}
	
	// 프로젝트 1건
	@GetMapping("/{pw_id}")
	public ProjectWorkDTO fetchProjectWorkById(@PathVariable(name="pw_id")int pw_id)
			throws ServerException, IOException {
		
		ProjectWorkDTO dto = service.get(pw_id);
		return dto;
	}
	
	// 프로젝트 업무 삭제
	@DeleteMapping("/{pw_id}")
	public void ProjectWorkDelete(@PathVariable(name="pw_id") int pw_id) 
			throws ServerException, IOException {
		
		service.delete(pw_id);
	}
	
	// 프로젝트 진척도
	@GetMapping("/progress/{team_id}")
	public List<ProjectProgressBarDTO> pjProgressBar (@PathVariable int team_id, HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("[Controller → pjProgressBar]");
		
		return service.pjProgressBar(team_id, req, model);
		
		
	}
	
}
