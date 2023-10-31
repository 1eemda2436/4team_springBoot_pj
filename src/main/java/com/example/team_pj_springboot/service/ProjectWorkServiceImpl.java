package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.team_pj_springboot.repository.ProjectWorkRepository;
import com.example.team_pj_springboot.dto.ProjectProgressBarDTO;
import com.example.team_pj_springboot.dto.ProjectWorkDTO;
import com.example.team_pj_springboot.mappers.ProjectProgressBarMapper;

@Service
public class ProjectWorkServiceImpl implements ProjectWorkService {

	@Autowired
	private ProjectWorkRepository dao;
	
	@Autowired
	private ProjectProgressBarMapper bardao;

	@Override
	public List<ProjectWorkDTO> list(int pj_id) {
		// TODO Auto-generated method stub
		return dao.findProjectWork(pj_id);
	}

	@Override
	public void save(ProjectWorkDTO dto) {
		// TODO Auto-generated method stub
		dao.save(dto);
	}

	@Override
	@Transactional
	public void saveComplete(int pw_id, String complete) {
		// TODO Auto-generated method stub
		dao.updateComplete(pw_id, complete);
	}
	
	@Override
	public ProjectWorkDTO get(int pw_id) {
		// TODO Auto-generated method stub
		return dao.findById(pw_id).get();
	}

	@Override
	public void delete(int pw_id) {
		// TODO Auto-generated method stub
		dao.deleteById(pw_id);
	}

	@Override
	public List<ProjectProgressBarDTO> pjProgressBar(int team_id, HttpServletRequest req, Model model) throws ServletException, IOException {
		
		List<ProjectProgressBarDTO> pjdto = bardao.pjProgressBar(team_id);
		
		return pjdto;
	}

	
//	@Override
//	public List<ProjectWorkDTO> listAll(HttpServletRequest req, Model model) 
//			throws ServletException, IOException {
//		return dao.findAll();
//	}
//
//	@Override
//	public void save(ProjectWorkDTO dto) 
//			throws ServletException, IOException {
//		dao.save(dto);
//		
//	}
//
//	@Override
//	public ProjectWorkDTO get(int pw_id) 
//			throws ServletException, IOException {
//		return dao.findById(pw_id).get();
//	}
//
//	@Override
//	public void delete(int pw_id) 
//			throws ServletException, IOException {
//		dao.deleteById(pw_id);
//	}

}
