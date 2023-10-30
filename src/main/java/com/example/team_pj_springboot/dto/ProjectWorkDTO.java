package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "project_work")
@Data
public class ProjectWorkDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pw_id;
	private int pj_id;
	private String pw_name;
	private Date pw_deadline_s;
	private Date pw_deadline_e;
	private String complete;

}
