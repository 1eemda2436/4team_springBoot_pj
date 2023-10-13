package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team")
@Data
public class TeamDTO {
	@Id
	private int 	team_id;	// 팀 id
    private String 	team_name;	// 팀명
    private int 	depart_id;	// 부서 id (FK)
    private char 	show;		// 공개 여부
}
