package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="notice")
@Data
public class NoticeDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq")
	@SequenceGenerator(name = "notice_seq", sequenceName = "notice_seq", allocationSize = 1)
	private int notice_id;
	private String title;
	private String content;
	private int hits;
	private Date reg_date;
	private String files;

}
