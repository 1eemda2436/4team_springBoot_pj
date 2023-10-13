package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.team_pj_springboot.repository.ProjectWorkRepository;
import com.example.team_pj_springboot.dto.ProjectWorkDTO;

@Service
public class ProjectWorkServiceImpl implements ProjectWorkService {

	@Autowired
	private ProjectWorkRepository dao;
	
	@Override
	public List<ProjectWorkDTO> listAll(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		return dao.findAll();
	}

	@Override
	public void save(ProjectWorkDTO dto) 
			throws ServletException, IOException {
		dao.save(dto);
		
	}

	@Override
	public ProjectWorkDTO get(int pw_id) 
			throws ServletException, IOException {
		return dao.findById(pw_id).get();
	}

	@Override
	public void delete(int pw_id) 
			throws ServletException, IOException {
		dao.deleteById(pw_id);
	}

}
