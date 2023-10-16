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
public class DocAndCategoryDTO {
	
	@Id
	private int doc_id;
	private Date doc_date;
	private String name;
	private String doc_content;
	private String doc_attachment;
	private String category_name;
	private int category_id;
	private String id;
	

}
