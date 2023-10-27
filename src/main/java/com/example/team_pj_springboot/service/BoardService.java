package com.example.team_pj_springboot.service;

import java.util.List;

import com.example.team_pj_springboot.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> listAll();
	public List<BoardDTO> boardFind(int board_id);
	public void insertBoard(BoardDTO dto);
	public void updateBoard(BoardDTO dto);
	public void deleteBoard(int board_id);
	public List<Object[]> findCategory();
	
}
