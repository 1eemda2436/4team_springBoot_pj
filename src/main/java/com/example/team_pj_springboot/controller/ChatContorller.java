package com.example.team_pj_springboot.controller;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class ChatContorller {
	
	@GetMapping("/chat")
	public String chatGET() {
		
		log.info("@ChatContorller, chat GET()");
		
		return "chat";
	}
	
}
