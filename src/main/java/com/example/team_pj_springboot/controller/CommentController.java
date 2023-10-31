package com.example.team_pj_springboot.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.team_pj_springboot.dto.CommentDTO;
import com.example.team_pj_springboot.service.CommentServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/comment")
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	private CommentServiceImpl service;

//	@GetMapping("/commentFind/{board_id}")
//	public List<CommentDTO> commentFind(@PathVariable int board_id, Model model) {
//		logger.info("CommentController - commentList");
//
//		List<CommentDTO> dto = service.commentFind(board_id);
//		model.addAttribute("dto", dto);
//		
//		return dto;
//	}
	
	@GetMapping("/commentFind/{board_id}")
    public List<CommentDTO> commentFind(@PathVariable int board_id) {
        logger.info("CommentController - commentList");

        List<CommentDTO> dto = service.commentFind(board_id);
        return dto;
    }
	
//	@GetMapping("/commentList")
//	public List<CommentDTO> commentList(){
//		return service.listAll();
//	}
	
	//Insert
	@PostMapping("/addComment")
	public void commentInsert(@RequestBody CommentDTO dto) {
		logger.info("CommentController - commentInsert");
		
		service.insertComment(dto);
	}
	
	//update
	@PutMapping("/editComment/{comment_id}")
	public void commentUpdate(@RequestBody CommentDTO dto) {
		logger.info("CommentController - commentUpdate");
		
		service.updateComment(dto);
	}
	
	//delete
	@DeleteMapping("/deleteComment/{comment_id}")
	public void commentDelete(@PathVariable("comment_id") int comment_id) {
		logger.info("CommentController - commentDelete");
		
		service.deleteComment(comment_id);
	}
	
	

}