package com.example.team_pj_springboot.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.ProjectAndTeamDTO;
import com.example.team_pj_springboot.dto.ProjectDTO;

// 프로젝트 repository
public interface ProjectRepository extends JpaRepository<ProjectDTO, Integer> {

	
}
