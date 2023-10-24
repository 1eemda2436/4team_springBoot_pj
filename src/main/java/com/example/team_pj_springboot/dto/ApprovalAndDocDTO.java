package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalAndDocDTO {

	@Id
	private int doc_id;
	private int approval_id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approval_date;
	private String approval_content;
	private String doc_title;
	private String doc_content;
	private String doc_attachment;
	private String id;
	private String doc_status;
	
	// 생성자 직접 정의
	public ApprovalAndDocDTO(int doc_id, int approval_id, String name, Date approval_date, String approval_content, String doc_title, String doc_content, String doc_attachment) {
		this.doc_id = doc_id;
		this.approval_id = approval_id;
		this.name = name;
		this.approval_date = approval_date;
		this.approval_content = approval_content;
		this.doc_title = doc_title;
		this.doc_content = doc_content;
		this.doc_attachment = doc_attachment;
	}
	
}
