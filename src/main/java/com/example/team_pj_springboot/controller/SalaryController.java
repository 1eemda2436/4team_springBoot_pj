package com.example.team_pj_springboot.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.service.SalaryService;


@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/salary") // 엔드포인트에 "/api"를 추가
public class SalaryController {
	private static final Logger logger = LoggerFactory.getLogger(SalaryController.class);
	
	@Autowired
	private SalaryService service;
	
	//http://localhost:8081/salaryMain
	@GetMapping("/salaryMain")
    public List<SalaryAndMemberDTO> salaryAndMemberInfo() {
		logger.info("[salaryAndMemberInfo]");
		
//		List<SalaryAndMemberDTO> list = service.getSalaryAndMemberInfo();
//		model.addAttribute("list", list);
		
        return service.getSalaryAndMemberInfo();
    }
	
	@GetMapping("/personnel")
	public List<MemberDTO> personnelInfo(){
		logger.info("[personnelInfo]");
		
//		List<MemberDTO> list = service.getPersonnelInfo();
//		model.addAttribute("list", list);
		
		return service.getPersonnelInfo();
	}
	
	
}
