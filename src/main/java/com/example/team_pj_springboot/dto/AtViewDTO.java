package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import lombok.Data;

@Entity
@Immutable
@Table(name="COMPANY_ATTENDANCE_VIEW")
@Data
public class AtViewDTO {
	
	@Id
	@Column(name = "ma_id")
    private int			ma_id;				// 구분
	
	@Column(name = "id")
    private String 		id;					// 사원번호
    
	@Column(name = "show_annual")
    private char 		show_annual;		// 연차/휴가(산재, 출산, 상) 여부
    
	@Column(name = "general_workin")
    private Timestamp 	general_workin;		// 출근 시간
    
	@Column(name = "general_workout")
    private Timestamp 	general_workout;	// 퇴근 시간
    
	@Column(name = "holiday_name")
    private String 		holiday_name;		// 휴가 사유 (산재, 출산, 조/부모 상 등)
    
	@Column(name = "gived_holiday")
    private Date 		gived_holiday;		// 주어진 휴가 기간
    
	@Column(name = "total_annual")
    private int 		total_annual;		// 총 연차
    
	@Column(name = "used_annual")
    private int 		used_annual;		// 사용한 연차
    
	@Column(name = "company_id")
    private String		company_id;			// 회사 id
    
	@Column(name = "depart_id")
    private int 		depart_id;			// 부서 id(소속)
    
	@Column(name = "team_id")
    private int			team_id;			// 팀 id
    
	@Column(name = "late_hours")
    private double 		late_hours;			// 지각 시간
    
	@Column(name = "overtime_hours")
    private double 		overtime_hours;		// 야근 시간
    
	@Column(name = "total_work_hours")
    private Double 		total_work_hours;	// 총 근무 시간
    
}
