package com.example.team_pj_springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.MyPageDTO;
import com.example.team_pj_springboot.service.MyPageServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/my")
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

	@Autowired
	private MyPageServiceImpl service;
	
	@GetMapping("/memberFind/{id}")
	public List<MyPageDTO> memberFind(@PathVariable String id, Model model) {
		logger.info("MyPageController - memberFind");
		
		List<MyPageDTO> dto = service.memberFind(id);
		model.addAttribute("dto", dto);
		
		return dto;
	}
	
	@PutMapping("/memberEdit/{id}")
	public void memberUpdate(@RequestBody MyPageDTO dto) {
		logger.info("MyPageController - memberUpdate");
		
		service.updateMember(dto);
	}
	
	
	
}