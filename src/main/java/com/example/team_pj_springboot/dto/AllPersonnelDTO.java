package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AllPersonnelDTO {
	
	private MemberDTO memberDTO;
	private String depart_name;
	private String team_name;
}
