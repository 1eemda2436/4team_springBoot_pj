package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.team_pj_springboot.repository.ProjectRepository;
import com.example.team_pj_springboot.dto.ProjectAndTeamDTO;
import com.example.team_pj_springboot.dto.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository dao;
	
	// List
	@Override
	public List<ProjectDTO> listAll(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		return dao.findAll();
	}

	// Insert : PK가 존재하지 않을때는 신규, PK가 존재할 때는 해당키의 데이터를 update
	@Override
	public void save(ProjectDTO dto)
			throws ServletException, IOException {
		dao.save(dto);
	}

	@Override
	public ProjectDTO get(int pj_id) 
			throws ServletException, IOException {
		return dao.findById(pj_id).get();
	}

	@Override
	public void delete(int pj_id)
			throws ServletException, IOException {
		dao.deleteById(pj_id);
		
	}

}
