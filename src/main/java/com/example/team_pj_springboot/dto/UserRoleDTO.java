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
@Table(name="user_role")
@Builder
@DynamicInsert
@Data
public class UserRoleDTO {
	@Id
	private int role_id;
	private String id;
	private int depart_id;
	private char securuty;
	private char attendance;
	private char salary;
	private char approval;
	private char personnel;
	private char board;
}