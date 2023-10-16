package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="doc")
@Data
@NoArgsConstructor
@DynamicInsert
public class DocDTO {

	@Id
	@SequenceGenerator(
	        name = "DOC_SEQ_GENERATOR",
	        sequenceName = "DOC_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOC_SEQ_GENERATOR")
	private int doc_id;				// 문서번호
	private Date doc_date;			// 작성일
	private String id;				// 사번
	private String doc_title;		// 문서제목
	private String doc_content;		// 문서내용
	private String doc_attachment;	// 첨부파일
	private Date doc_enddate;		// 마감일
	private int category_id;		// 카테고리번호
	private char doc_status;		// 문서상태
	private char doc_read;			// 회람여부
	private String name;			// 이름
	
	
	public DocDTO(int doc_id, Date doc_date, String id, String doc_title, String doc_content, String doc_attachment, Date doc_enddate, int category_id, char doc_status, char doc_read, String name) {
	    this.doc_id = doc_id;
	    this.doc_date = doc_date;
	    this.id = id;
	    this.doc_title = doc_title;
	    this.doc_content = doc_content;
	    this.doc_attachment = doc_attachment;
	    this.doc_enddate = doc_enddate;
	    this.category_id = category_id;
	    this.doc_status = doc_status;
	    this.doc_read = doc_read;
	    this.name = name;
	}

}
