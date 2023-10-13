package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.CategoryDTO;

public interface CategoryRepository extends JpaRepository<CategoryDTO, Integer> {
	
}