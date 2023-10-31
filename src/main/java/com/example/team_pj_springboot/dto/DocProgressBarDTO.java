package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocProgressBarDTO {
	
		@Id
		private int doc_id;            // 문서번호
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date doc_date;         // 작성일
		private String id;            // 사번
		private String doc_title;      // 문서제목
		private String doc_content;      // 문서내용
		private String doc_attachment;   // 첨부파일
		private String sign;   // sign 첨부파일
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date doc_endDate;      // 마감일
		private int category_id;      // 카테고리번호
		private String doc_status;      // 문서상태
		private String doc_read;         // 회람여부
		private String name;         // 이름
		private String approval_content;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date approval_date;
		private String company_id;
		private String admin_sign;
		private int docConfirmCount;
		private int docDoingCount;
		private int docReturnCount;
		private int docNewCount;
		private int docLaterCount;
		private int allDocCount;

}
