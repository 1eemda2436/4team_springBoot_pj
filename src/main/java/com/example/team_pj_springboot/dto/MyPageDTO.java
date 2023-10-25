package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="member")
@Data
public class MyPageDTO {

	@Id
	private String id;
	private String company_id;
	private String pwd;
	private String name;
	private String email;
	private String tel;
	private String profile;
	private Date hireDate;
	private Date resignation;
	private Date birthday;
	private int resident;
	private int depart_id;
	private int team_id;
	private String rank;
	private int salary;
	private String bank;
	private String contract;
	private String sign;
	private char e_state;
	private char state;
	private String key;
	private char enabled;
	private String authority;
	private String token;
	private String authoriry;
	
	public MyPageDTO() {
		
	}
}
