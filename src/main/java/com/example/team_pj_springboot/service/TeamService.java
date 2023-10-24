package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.team_pj_springboot.dto.TeamDTO;

public interface TeamService {
	
	public List<TeamDTO> listAll(HttpServletRequest req, Model model)
			throws ServletException, IOException;

}
