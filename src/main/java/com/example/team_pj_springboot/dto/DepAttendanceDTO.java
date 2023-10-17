package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class DepAttendanceDTO {
	
	@Id
	private int 		depart_id;		// 부서번호
	private String 		depart_name;	// 부서명
	private String 		name;			// 사원이름
	private Timestamp 	general_workin;	// 출근시간
	private Timestamp 	general_workout;// 퇴근시간
	private String 		holiday_name;	// 휴가 사
	private Date 		gived_holiday;	// 휴가 기간

}
