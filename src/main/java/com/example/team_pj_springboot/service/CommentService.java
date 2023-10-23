package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.team_pj_springboot.dto.CommentDTO;

public interface CommentService {

	public List<CommentDTO> listAll();
	public List<CommentDTO> commentFind(int board_id);
	public void insertComment(CommentDTO dto);
	public void updateComment(CommentDTO dto);
	public void deleteComment(int comment_id);
}
