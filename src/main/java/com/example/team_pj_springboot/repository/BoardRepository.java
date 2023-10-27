package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.BoardDTO;

public interface BoardRepository extends JpaRepository<BoardDTO, Integer>{

	@Query("SELECT b FROM BoardDTO b WHERE b.board_id = :board_id")
	List<BoardDTO> findBoardByBoardID(@Param("board_id") int board_id);
	
	@Query("SELECT DISTINCT b.category_id, c.category_name " +
			"FROM BoardDTO b " +
			"LEFT JOIN BoardCategoryDTO c ON b.category_id = c.category_id " + 
			"ORDER BY b.category_id")
    List<Object[]> findCategory();

}