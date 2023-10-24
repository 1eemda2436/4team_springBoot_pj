package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRepository dao;
	
	@Override
	public List<TeamDTO> listAll(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		return dao.findAll();
	}

}
