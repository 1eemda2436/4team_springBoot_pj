package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="doc_readView")
@Data
public class ViewDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doc_id;
	private String id;
	private String doc_title;
	private String doc_content;
	private String doc_attachment;
	private Date doc_date;
	private Date doc_endDate;
	private int category_id;
	private char doc_status;
	private char doc_read;
	private String name;
	
}
