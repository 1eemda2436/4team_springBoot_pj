package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.team_pj_springboot.dto.BoardCategoryDTO;
import com.example.team_pj_springboot.dto.BoardDTO;
import com.example.team_pj_springboot.dto.CategoryDTO;
import com.example.team_pj_springboot.repository.BoardCategoryRepository;
import com.example.team_pj_springboot.repository.BoardRepository;
import com.example.team_pj_springboot.repository.CategoryRepository;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardCategoryRepository categoryRepository;
	
	@Override
	public List<BoardDTO> listAll() {
		return boardRepository.findAll();
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		boardRepository.save(dto);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		boardRepository.save(dto);
	}

	@Override
	public void deleteBoard(int board_id) {
		System.out.println(board_id);
		boardRepository.deleteById(board_id);
	}

	@Override
	public List<BoardDTO> boardFind(int board_id) {
		return boardRepository.findBoardByBoardID(board_id);
	}
	
	//categories 목록
	public List<BoardCategoryDTO> categoriesSelect () {
		return categoryRepository.findAll();
	}

}
