package com.example.team_pj_springboot.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MEMBER")
@Builder
@DynamicInsert
@Data
public class Member {
	
	@Id
    private String id;
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
    private char state; // 사원 업무상태 (1-업무중 / 2-외출 / 3-비활성화)
    private char e_state; // 재직여부(1-재직, 0-퇴사)
    private String key; // 문자인증 키
    private String authority; // 권한
    private char enabled; // 인증여부 (Y/N)
}