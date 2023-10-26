package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.team_pj_springboot.dto.ProjectWorkDTO;

public interface ProjectWorkService {
	
	public List<ProjectWorkDTO> listAll(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	public void save(ProjectWorkDTO dto)
			throws ServletException, IOException;
	
	public ProjectWorkDTO get(int pw_id)
			throws ServletException, IOException;
	
	public void delete(int pw_id)
			throws ServletException, IOException;

}
