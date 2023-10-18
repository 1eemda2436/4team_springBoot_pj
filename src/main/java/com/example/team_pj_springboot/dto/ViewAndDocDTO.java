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
public class ViewAndDocDTO {
	
	@Id
	private int doc_id;
	private String category_name;
	private String doc_title;
	private String name;
	private Date doc_date;
	private char doc_read;
	

}
