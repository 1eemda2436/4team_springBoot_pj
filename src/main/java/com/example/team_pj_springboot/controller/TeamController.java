package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.service.TeamService;
import com.example.team_pj_springboot.service.TeamServiceImpl;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/team")
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private TeamServiceImpl teamService;
	
	// 팀 리스트
	@GetMapping
	public List<TeamDTO> TeamList(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		logger.info("[ url - TeamList ]");
		
		return teamService.listAll(req, model);
	}
   
   @GetMapping("/select/{depart_id}")
   public List<TeamDTO> teamSelect(@PathVariable int depart_id){
      System.out.println(teamService.teamSelect(depart_id));
      return teamService.teamSelect(depart_id);
   }
   
   //team insert
   @PostMapping("/add")
   public TeamDTO teamAdd (@RequestBody TeamDTO dto) {
      TeamDTO teamDTO = new TeamDTO();
      teamDTO.setDepart_id(dto.getDepart_id());
      teamDTO.setTeam_name(dto.getTeam_name());
      return teamService.teamAdd(teamDTO);
   }
   
   //teamUpdate
   @PutMapping("/TeamUpdate")
   public void TeamUpdate(@RequestBody TeamDTO dto) {
	   teamService.TeamUpdate(dto);
   }
   
   //teamDelete-Update show = 'N'
   @PutMapping("/delete/{team_id}")
   public void TeamDelete(@PathVariable int team_id) {
	   teamService.teamDelete(team_id);
   }
   
}
