package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.repository.TeamRepository;

@Service
public class TeamService {

   @Autowired
   private TeamRepository teamRepository;
  
   public List<TeamDTO> listAll(HttpServletRequest req, Model model)
			throws ServletException, IOException;
   
   //teamSelect
   public List<TeamDTO> teamSelect(int depart_id){
      return teamRepository.findTeamsByDepartId(depart_id);
   }
   
   //teamInsert
   public TeamDTO teamAdd (TeamDTO dto) {
      return teamRepository.save(dto);
   }
   
   //teamUpdate
   public void TeamUpdate(@RequestBody TeamDTO dto) {
	   teamRepository.save(dto);
   }
   
   //teamDelete-Update show = 'N'
   public void teamDelete(int team_id) {
	   teamRepository.teamDeleteUpdate(team_id);
   }
   
}
