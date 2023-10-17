package com.example.team_pj_springboot.dto;

import java.sql.Date;

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
@Table(name="member")
@DynamicInsert
@Data
public class MemberDTO {
	
	@Id
    private String id; // 사원 고유 번호
    private String company_id; // 회사 id
    private String pwd; // 사원 비밀번호
    private String name; // 사원 이름
    private String email; // 사원 이메일
    private String tel; // 사원 전화번호
    private String profile; // 프로필 사진
    private Date hireday; // 입사일
    private Date resignation; // 퇴사일
    private Date birthday; // 생일
    private int resident; // 주민 번호
    private int depart_id; // 부서 id(소속)
    private Integer team_id; // 팀 id (Nullable)
    private String rank; // 직급
    private int salary; // 연봉
    private String bank; // 계좌
    private String contract; // 계약 형태(유형)
    private String sign; // 사원 사인 이미지
    private char state = 1; // 사원 업무상태 (1-업무중 / 2-외출 / 3-비활성화)
    private char e_state = 1; // 재직여부(1-재직, 0-퇴사)
    private String key; // 문자인증 키
    private String authority; // 권한
    private char enabled = 'N'; // 인증여부 (Y/N)
    private String token;
}


//--사내 임직원
//CREATE TABLE MEMBER(
//   id         	varchar2(50)   	PRIMARY KEY,   	--사원 고유 번호
//   company_id 	varchar2(50)   	NOT NULL,      	--회사 id
//   pwd         	varchar2(100)   NOT NULL,      	--사원 비밀번호
//   name      		varchar2(30)   	NOT NULL,      	--사원 이름
//   email      	varchar2(100)   NOT NULL,      	--사원 이메일
//   tel         	varchar2(30)   	NOT NULL,      	--사원 전화번호
//   profile      	varchar2(100),               	--프로필 사진
//   hireday      	DATE         	NOT NULL,      	--입사일
//   Resignation  	DATE,                     		--퇴사일
//   birthday   	DATE,                     		--생일
//   resident   	NUMBER         	NOT NULL,      	--주민 번호
//   depart_id   	NUMBER(4)      	NOT NULL,      	--부서 id(소속)
//   team_id      	NUMBER(4),                  	--팀 id
//   RANK      		varchar2(50)   	NOT NULL,      	--직급
//   salary      	NUMBER         	NOT NULL,      	--연봉
//   bank      		varchar2(50),               	--계좌
//   contract   	varchar2(50)   	NOT NULL,      	--계약 형태(유형)
//   sign      		varchar2(100),               	--사원 사인 이미지
//   state      	char(1)      	DEFAULT '1'	NOT NULL,      	--사원 업무상태 (1-업무중 / 2-외출 / 3-비활성화)
//   e_state      	char(1)      	DEFAULT '1'	NOT NULL,      	--재직여부(1-재직, 0-퇴사)
//   KEY         	varchar2(100)   NOT NULL,      	--문자인증 키
//   authoriry   	varchar2(30)   	NOT NULL,      	--권한
//   enabled      	char(1)         DEFAULT 'N'	NOT NULL CONSTRAINT member_enabled_chk CHECK(enabled IN('Y', 'N')),      	--인증여부
//   CONSTRAINT memberTBL_company_id FOREIGN KEY (company_id) REFERENCES company(company_id) ON DELETE CASCADE,
//   CONSTRAINT memberTBL_depart_id FOREIGN KEY (depart_id) REFERENCES department(depart_id),
//   CONSTRAINT memberTBL_team_id FOREIGN KEY (team_id) REFERENCES team(team_id)
//);
//SELECT * FROM MEMBER;
