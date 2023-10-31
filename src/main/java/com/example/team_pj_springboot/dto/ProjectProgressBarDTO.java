package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectProgressBarDTO {
	
	@Id
	private int 	pj_id;
	private String 	pj_name;
	private String 	content;
	private Date 	deadline_s;
	private Date 	deadline_e;
	private int 	team_id;
	private int 	pw_id;
	private String 	pw_name;
	private Date 	pw_deadline_s;
	private Date 	pw_deadline_e;
	private String 	complete;
	private int 	complete_count;
	private int 	pw_id_count;


}
