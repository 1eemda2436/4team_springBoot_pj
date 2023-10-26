package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.CommentDTO;
import com.example.team_pj_springboot.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository dao;
	
	@Override
	public List<CommentDTO> listAll() {
		return dao.findAll();
	}
	
	@Override
	public List<CommentDTO> commentFind(int board_id){
		return dao.findBoardCommentsByBoardId(board_id);
	}

	@Override
	public void insertComment(CommentDTO dto) {
		dao.save(dto);
	}

	@Override
	public void updateComment(CommentDTO dto) {
		dao.save(dto);
	}

	@Override
	public void deleteComment(int comment_id) {
		dao.deleteById(comment_id);
	}

	
}
