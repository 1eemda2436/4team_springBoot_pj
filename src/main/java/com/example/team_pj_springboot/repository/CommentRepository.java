package com.example.team_pj_springboot.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.CommentDTO;

public interface CommentRepository extends JpaRepository<CommentDTO, Integer>{

//	@Query("SELECT * FROM board_comment " + 
//			"WHERE board_id = :board_id")
//	List<CommentDTO> findBoard_idComment(@Param("board_id") int board_id);
	
	@Query("SELECT c FROM CommentDTO c WHERE c.board_id = :board_id")
	List<CommentDTO> findBoardCommentsByBoardId(@Param("board_id") int board_id);

	
}
