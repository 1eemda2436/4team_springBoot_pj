package com.example.team_pj_springboot.service;

import java.util.List;

import com.example.team_pj_springboot.dto.ProjectDTO;

public interface ProjectService  {
	
	//프로젝트 전체목록
	public List<ProjectDTO> listAll(int team_id);
	
	//프로젝트 수정/생성
	public void save(ProjectDTO dto);
	
	// 프로젝트 수정을 위한 조회
	public ProjectDTO get(int pj_id);
	
	// 프로젝트 삭제
	public void delete(int pj_id);

}
