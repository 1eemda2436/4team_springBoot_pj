package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.ProjectWorkDTO;

// 프로젝트 업무 repository
public interface ProjectWorkRepository extends JpaRepository<ProjectWorkDTO, Integer> {

}
