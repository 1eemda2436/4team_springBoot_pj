package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="doc_approval")
@Data
public class ApprovalDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int approval_id;
	private String approval_name;
	private String id;
	private int doc_id;
	private String approval_content;
	private Date approval_date;
	private Date approval_endDate;
	private String doc_status;
	
}
