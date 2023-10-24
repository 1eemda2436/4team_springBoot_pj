package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.team_pj_springboot.dto.ProjectAndTeamDTO;
import com.example.team_pj_springboot.dto.ProjectDTO;

public interface ProjectService  {
	
	public List<ProjectDTO> listAll(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	public void save(ProjectDTO dto)
			throws ServletException, IOException;
	
	public ProjectDTO get(int pj_id)
			throws ServletException, IOException;
	
	public void delete(int pj_id)
			throws ServletException, IOException;

}
