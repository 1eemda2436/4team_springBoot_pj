package com.example.team_pj_springboot.mappers;

import com.example.team_pj_springboot.dto.AttendanceDTO;

public interface GuestMapper {
	
	public AttendanceDTO todayWorkTime(int ma_id);		// 오늘 근무 시간
	public AttendanceDTO weeklyWorkTime(int ma_id);		// 주간 총 근무 시간
	

}
