package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComAttendanceDTO {
	
	@Id
	private String 	company_id;		// 회사 번호
	private String 	name;			// 회사명
	private int 	depart_id;		// 부서번호
	private String 	depart_name;	// 부서명
	private int 	lateCount;		// 지각 횟수
	private int 	holidayCount;	// 연차 휴가자 수
	private int		workinCount;	// 출근자 수

}
