package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.BoardDTO;
import com.example.team_pj_springboot.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository dao;
	
	@Override
	public List<BoardDTO> listAll() {
		return dao.findAll();
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		dao.save(dto);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		dao.save(dto);
	}

	@Override
	public void deleteBoard(int board_id) {
		System.out.println(board_id);
		dao.deleteById(board_id);
	}

}
