package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="MEMBER_ATTENDANCE")
@Data
public class AttendanceDTO {
	
	@Id
    private int			ma_id;				// 구분
    private String 		id;					// 사원번호
    private char 		show_annual;		// 연차/휴가(산재, 출산, 상) 여부
    private Timestamp 	general_workin;		// 출근 시간
    private Timestamp 	general_workout;	// 퇴근 시간
    private String 		holiday_name;		// 휴가 사유 (산재, 출산, 조/부모 상 등)
    private Date 		gived_holiday;		// 주어진 휴가 기간
    private int 		total_annual;		// 총 연차
    private int 		used_annual;		// 사용한 연차
}
