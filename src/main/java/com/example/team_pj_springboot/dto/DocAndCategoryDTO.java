package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DocAndCategoryDTO {
	
	@Id
	private int doc_id;
	private Date doc_date;
	private String name;
	private String doc_title;
	private String doc_content;
	private String doc_attachment;
	private String category_name;
	private int category_id;
	private String id;
	
	// 생성자 직접 정의
    public DocAndCategoryDTO(int doc_id, Date doc_date, String name, String doc_title, String doc_content, String doc_attachment,
            String category_name) {
        this.doc_id = doc_id;
        this.doc_date = doc_date;
        this.name = name;
        this.doc_title = doc_title;
        this.doc_content = doc_content;
        this.doc_attachment = doc_attachment;
        this.category_name = category_name;
    }

}
