package com.example.team_pj_springboot.controller;

import java.util.List;

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

import com.example.team_pj_springboot.dto.BoardDTO;
import com.example.team_pj_springboot.dto.CommentDTO;
import com.example.team_pj_springboot.dto.DocAndDraftDTO;
import com.example.team_pj_springboot.service.BoardServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/community")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	        
	@Autowired
	private BoardServiceImpl service;
	
	@GetMapping("/list")
	public List<BoardDTO> boardList() {
		logger.info("BoardController - boardList");
		
//		List<BoardDTO> list = service.listAll();
		
		return service.listAll();
	}
	@GetMapping("/boardFind/{board_id}")
	public List<BoardDTO> boardFind(@PathVariable int board_id, Model model) {
		logger.info("CommentController - commentList");

		List<BoardDTO> dto = service.boardFind(board_id);
		model.addAttribute("dto", dto);
		
		return dto;
	}
	
	//Insert
	@PostMapping("/add")
	public void boardInsert(@RequestBody BoardDTO dto) {
		logger.info("BoardController - boardInsert");
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		service.insertBoard(dto);
	}
	
	@PutMapping("/edit/{board_id}")
	public void boardUpdate(@RequestBody BoardDTO dto) {
		logger.info("BoardController - boardUpdate");
		
		service.insertBoard(dto);
	}
	 
	// Delete
	@DeleteMapping("/boardDelete")
	public void boardDelete(@RequestBody List<Integer> board_id) {
	    logger.info("BoardController - boardDelete");

	    for (Integer boardId : board_id) {
	        service.deleteBoard(boardId);
	    }
	}
	
	// 카테고리
	@GetMapping("/category")
	public List<Object[]> findCategory() {
		logger.info("[ url - findCategory ]");
		
		return service.findCategory();
	}
	
}