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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.service.TeamServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/team")
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private TeamServiceImpl service;
	
	// 팀 리스트
	@GetMapping
	public List<TeamDTO> TeamList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		logger.info("[ url - TeamList ]");
		
		return service.listAll(req, model);
		
	}

}
