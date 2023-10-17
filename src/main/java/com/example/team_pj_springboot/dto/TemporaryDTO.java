package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="doc_save")
@Data
public class TemporaryDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int save_id;
	private int doc_id;
	private String id;
	private Date save_date;
	
}
