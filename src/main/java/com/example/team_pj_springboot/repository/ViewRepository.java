package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team_pj_springboot.dto.DocDTO;

public interface ViewRepository extends JpaRepository<DocDTO, Integer> {

	
}
