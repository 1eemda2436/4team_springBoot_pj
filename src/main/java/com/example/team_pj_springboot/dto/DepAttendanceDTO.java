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
public class DepAttendanceDTO {
	
	@Id
	private int 		depart_id;		// 부서번호
	private String 		depart_name;	// 부서명
	private String		id;
	private String 		name;			// 사원이름
	private Timestamp 	general_workin;	// 출근시간
	private Timestamp 	general_workout;// 퇴근시간
	private String 		holiday_name;	// 휴가 사
	private Date 		gived_holiday;	// 휴가 기간
    private int 		annualCount; 	// 연차/휴가 여부를 저장할 필드
    private Double		averageWorkin; 	// 출근 시간 평균을 저장할 필드
    private Double		averageWorkout; // 퇴근 시간 평균을 저장할 필드
    private String 		workinRate;		// 출근율
    private String 		timelate;		// 지각률
    private String 		annualRate;		// 연차률
    private int 		lateCount;		// 지각자 수
    private int 		holidayCount;	// 쉬는사람 수
    private int			latedCount;		// 지각 횟수
	


}
