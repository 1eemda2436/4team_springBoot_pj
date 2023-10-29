package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="member")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonnelMemberDTO {
	
	@Id
	private String id;////////////////////
	
	@Column(name = "company_id")
    private String company_id; // 회사 id////////////////////
	
	@Column(name = "pwd")
    private String pwd = "$2a$10$m4N614ccTzwrpiYG3hYf/.tGo.D0/y5QGF.nvk3M9mzru5Y2Vbdwa"; // 사원 비밀번호////////////////////
	
	@Column(name = "name")
    private String name; // 사원 이름
	
	@Column(name = "email")
    private String email = "1"; // 사원 이메일
	
	@Column(name = "tel")
    private String tel; // 사원 전화번호////////////////////
	
	@Column(name = "profile")
    private String profile; // 프로필 사진
	
	@Column(name = "hireday")
    private Date hireday; // 입사일
	
	@Column(name = "resignation")
    private Date resignation; // 퇴사일
	
	@Column(name = "birthday")
    private Date birthday; // 생일
	
	@Column(name = "resident")
    private int resident = 1111111111; // 주민 번호
	
	@Column(name = "depart_id")
    private int depart_id; // 부서 id(소속)
	
	@Column(name = "team_id")
    private Integer team_id; // 팀 id (Nullable)
	
	@Column(name = "rank")
    private String rank = "임시"; // 직급
	
	@Column(name = "salary")
    private int salary = 0; // 연봉
	
	@Column(name = "bank")
    private String bank; // 계좌
	
	@Column(name = "contract")
    private String contract = "임시"; // 계약 형태(유형)
	
	@Column(name = "sign")
    private String sign; // 사원 사인 이미지
	
	@Column(name = "state")
    private char state = '1'; // 사원 업무상태 (1-업무중 / 2-외출 / 3-비활성화)
	
	@Column(name = "e_state")
    private char e_state = '1'; // 재직여부(1-재직, 0-퇴사)
	
	@Column(name = "key")
    private String key = " "; // 문자인증 키
	
	@Column(name = "authority")
    private String authority = "ROLE_USER"; // 권한
	
	@Column(name = "enabled")
    private char enabled  = 'N'; // 인증여부 (Y/N)

}
