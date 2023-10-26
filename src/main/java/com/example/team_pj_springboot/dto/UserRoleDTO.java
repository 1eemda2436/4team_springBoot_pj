package com.example.team_pj_springboot.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String id;
	private char security;
	private char attendance;
	private char salary;
	private char approval;
	private char personnel;
	private char board;
	@Transient
	private String rank;
}