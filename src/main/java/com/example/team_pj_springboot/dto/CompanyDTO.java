package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="company")
@Builder
@DynamicInsert
@Data
public class CompanyDTO {
	
	@Id
    @Column(name = "company_id") // 회사 id
    private String companyId; // 회사 id
	
	private String name; //회사명
	private String address; //회사 주소
	private int employees; //직원 수
	private String manager; //담당자명
	private String email; //회사 이메일
	private Timestamp work_in; //회사 근무내규 _ 출근시간
	private Timestamp work_out; //회사 근무내규 _ 퇴근시간
	private String key; //이메일 인증 키
	private char enabled; //인증여부 
}