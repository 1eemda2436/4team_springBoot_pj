package com.example.team_pj_springboot.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="department")
@Data
public class DepartmentDTO {
	@Id
	private int 	depart_id;		// 부서 id
    private String 	depart_name;	// 부서명
    private String 	company_id;		// 회사 id (FK)
    private char 	show;			// 공개여부
//    private List<MemberDTO> members;
//    private List<AttendanceDTO> attendances;
}
