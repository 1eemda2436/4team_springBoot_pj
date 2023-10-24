package com.example.team_pj_springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/admin/team") 
public class TeamController {
   private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
   
   @Autowired
   private TeamService teamService;
   
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