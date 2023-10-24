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
public class MyAttendanceDTO {
	
	@Id
    private int			ma_id;				// 구분
    private String 		id;					// 사원번호
	private int 		depart_id;			// 부서번호
	private String 		depart_name;		// 부서명
	private String 		name;				// 사원이름
    private char 		show_annual;		// 연차/휴가(산재, 출산, 상) 여부
    private Timestamp 	general_workin;		// 출근 시간
    private Timestamp 	general_workout;	// 퇴근 시간
    private String 		holiday_name;		// 휴가 사유 (산재, 출산, 조/부모 상 등)
    private Date 		gived_holiday;		// 주어진 휴가 기간
    private int 		total_annual;		// 총 연차
    private int 		used_annual;		// 사용한 연차
    private int			annuallastcount;	// 잔여 연차
    private int			worklate;			// 지각계
    private int			noworking;			// 결근계
    private int			earlyout;			// 조퇴계
    private double		totalWeekWork;		// 주간 총 근무시간
    private double		totalWeekOver;		// 주간 총 야근시간
    private double		remainWeekTime;		// 남은 총 근무시간
    private int			todaymyOT;			// 금일 내 추가 근무 시간
    private double		totalmyWork;		// 금일 내 총 근무시간
    private String 		vacation_title;		// 휴가 글 제목
    private Date		vacation_start;		// 휴가 시작날짜
    private Date		vacation_end;		// 휴가 종료날짜
    private int			vacationTerm;		// 휴가 기간
    private String 		vacation_content;	// 글 내용

}
