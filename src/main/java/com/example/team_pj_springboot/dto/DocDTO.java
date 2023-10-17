package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="doc")
@Data
public class DocDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doc_id;				// 문서번호
	private String id;				// 사번
	private String doc_title;		// 문서제목
	private String doc_content;		// 문서내용
	private String doc_attachment;	// 첨부파일
	private Date doc_date;			// 작성일
	private Date doc_enddate;		// 마감일
	private int category_id;		// 카테고리번호
	private char doc_status;		// 문서상태
	private char doc_read;			// 회람여부
	private String name;			// 이름
	
}
