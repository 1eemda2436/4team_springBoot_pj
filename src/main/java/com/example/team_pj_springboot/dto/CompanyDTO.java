package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDTO {
	private String company_id; //회사 id
	private String name; //회사명
	private String address; //회사 주소
	private int employees; //직원 수
	private String email; //회사 이메일
	private Timestamp work_in; //회사 근무내규 _ 출근시간
	private Timestamp work_out; //회사 근무내규 _ 퇴근시간
	private String key; //이메일 인증 키
	private String authoriry; //권한
	private char enabled; //인증여부 
}