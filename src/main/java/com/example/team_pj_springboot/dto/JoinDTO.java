package com.example.team_pj_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JoinDTO {
	private CompanyDTO companyDTO;
	private DepartmentDTO departmentDTO;
	private TeamDTO teamDTO;
	private MemberDTO memberDTO;
}
