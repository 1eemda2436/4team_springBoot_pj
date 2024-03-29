package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalIngAndDocDTO {
	
	@Id
	private int doc_id;
	private String doc_title;
	private String doc_status;
	private String name;
	private Date doc_date;
	private int category_id;
	private String id;
	private String company_id;
	
	// 생성자 직접 정의
	public ApprovalIngAndDocDTO(int doc_id, String doc_title, String doc_status, String name, String company_id, Date doc_date) {
		this.doc_id = doc_id;
		this.doc_title = doc_title;
		this.doc_status = doc_status;
		this.name = name;
		this.company_id = company_id;
		this.doc_date = doc_date;
	}

}
