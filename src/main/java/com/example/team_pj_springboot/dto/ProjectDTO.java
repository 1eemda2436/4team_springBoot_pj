package com.example.team_pj_springboot.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "project")
@Data
public class ProjectDTO {
	
	@Id
	private int pj_id;
	private String pj_name;
	private String content;
	private Date deadline_s;
	private Date deadline_e;
	private String depart_id;
	
	

}
