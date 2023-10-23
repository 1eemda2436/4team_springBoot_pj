package com.example.team_pj_springboot.dto;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class DepartmentListDTO {
	
	@Id
	private int depart_id;
    private String name;
    private int team_id;
    private String depart_name;
    private String team_name;
    private int pj_id;
    private String pj_name;
    private Date deadline_s;
    private Date deadline_e;

}