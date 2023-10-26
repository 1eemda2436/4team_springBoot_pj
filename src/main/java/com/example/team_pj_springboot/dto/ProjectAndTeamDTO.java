package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAndTeamDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pj_id;
    private String pj_name;
    private Date deadline_s;
    private Date deadline_e;
    private Integer team_id;    // 팀 id
    private String team_name;    // 팀명
    private Integer depart_id;    // 부서 id (FK)
    private String depart_name;  // 부서명

}
