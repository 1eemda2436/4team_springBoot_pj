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
public class TeamAndAttenDTO {
	
	@Id
    private int 		team_id;    	// 팀 id
    private String 		team_name;    	// 팀명
    private int 		depart_id;    	// 부서 id (FK)
    private char 		show = 'Y';   	// 공개 여부
	private String 		depart_name;	// 부서명
	private String		id;
	private String 		name;			// 사원이름
    private int 		annualCount; 	// 연차/휴가 여부를 저장할 필드
    private Double		averageWorkin; 	// 출근 시간 평균을 저장할 필드
    private Double		averageWorkout; // 퇴근 시간 평균을 저장할 필드
}
