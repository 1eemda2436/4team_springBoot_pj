package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.service.SalaryService;


@RestController
public class SalaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(SalaryController.class);
	
	@Autowired
	private SalaryService service;
	
	//http://localhost:8081/salaryMain
	@GetMapping("/salaryMain")
    public List<SalaryAndMemberDTO> salaryAndMemberInfo() {
		logger.info("[salaryAndMemberInfo]");
		
        return service.getSalaryAndMemberInfo();
    }
	
	@GetMapping("/personnel")
	public List<MemberDTO> personnelInfo(Model model){
		logger.info("[personnelInfo]");
		
		List<MemberDTO> list = service.getPersonnelInfo();
		model.addAttribute("list", list);
		
		return list;
	}
	
	
}
