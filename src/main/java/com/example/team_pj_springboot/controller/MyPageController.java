package com.example.team_pj_springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.MyPageDTO;
import com.example.team_pj_springboot.service.MyPageServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/my")
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

	@Autowired
	private MyPageServiceImpl service;

	// 마이페이지 진입을 위한 조회
	@GetMapping("/member/{id}")
	public AllPersonnelDTO fetchMemberById(@PathVariable(name="id")String id) {
		logger.info("[ url - fetchMemberById]");
		
		AllPersonnelDTO member = service.get(id);
		return member;
	}
	
	// 마이페이지 수정
	@PutMapping("/memberModify")
	public void save(@RequestBody MemberDTO member) {
		logger.info("[ url - memberModify ]");
		System.out.println(member);
		service.save(member);
	}
	
}
