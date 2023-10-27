package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.team_pj_springboot.dto.ProjectAndTeamDTO;
import com.example.team_pj_springboot.dto.ProjectDTO;

public interface ProjectService  {
	
	//프로젝트 전체목록
	public List<ProjectDTO> listAll(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	//프로젝트 수정/생성
	public void save(ProjectDTO dto)
			throws ServletException, IOException;
	
	// 프로젝트 수정을 위한 조회
	public ProjectDTO get(int pj_id)
			throws ServletException, IOException;
	
	// 프로젝트 삭제
	public void delete(int pj_id)
			throws ServletException, IOException;

}
