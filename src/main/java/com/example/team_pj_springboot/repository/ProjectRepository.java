package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.ProjectDTO;

// 프로젝트 repository
public interface ProjectRepository extends JpaRepository<ProjectDTO, Integer> {

}
