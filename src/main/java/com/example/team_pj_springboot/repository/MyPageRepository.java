package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.MyPageDTO;

public interface MyPageRepository extends JpaRepository<MyPageDTO, String>{

	@Query("SELECT m FROM MyPageDTO m WHERE m.id = :id")
	List<MyPageDTO> findMemeberByMyPageDTO(@Param("id") String id);
	
}
