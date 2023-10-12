package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class SalaryAndMemberDTO {
	
	@Id
    private int s_id;
    private String id;
    private String name;
    private int resident;
    private String contract;
    private int depart_id;
    private String rank;
    private char state;
    private char estate;
    private int salary;
}
