package com.example.team_pj_springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.NoticeDTO;
import com.example.team_pj_springboot.service.NoticeServiceImpl;


@RestController 
@RequestMapping
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeServiceImpl service;
	
	@GetMapping("/guest/notice/noticeList")
	public List<NoticeDTO> noticeList(Model model) {
		logger.info("NoticeController - noticeList");
		
		List<NoticeDTO> list = service.listAll();
		model.addAttribute("list", list);
		
		return service.listAll();
	}
	@GetMapping("/guest/notice/noticeFind/{notice_id}")
	public List<NoticeDTO> noticeFind(@PathVariable int notice_id, Model model) {
		logger.info("NoticeController - noticeFind");
		
		List<NoticeDTO> dto = service.noticeFind(notice_id);
		model.addAttribute("dto", dto);
	
		return dto;
	}
	
	// Insert
	@PostMapping("/admin/notice/addNotice")
	public void noticeInsert(@RequestBody NoticeDTO dto) {
		logger.info("NoticeController - noticeInsert");
		
		service.insertNotice(dto);
	}
	
	// edit
	@PutMapping("/admin/notice/editNotice/{notice_id}")
	public void noticeUpdate(@RequestBody NoticeDTO dto,@PathVariable int notice_id) {
		logger.info("NoticeController - noticeUpdate");
		dto.setNotice_id(notice_id);
		service.updateNotice(dto);
		
	}
	
	// Delete
	@DeleteMapping("/admin/notice/deleteNotice/{notice_id}")
	public void noticeDelete(@PathVariable("notice_id") int notice_id) {
		
		service.deleteNotice(notice_id);
	}
}