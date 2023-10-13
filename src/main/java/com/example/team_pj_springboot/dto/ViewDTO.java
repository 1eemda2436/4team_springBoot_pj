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
@Table(name="doc_readView")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class ViewDTO {

	@Id
	@SequenceGenerator(
	        name = "VIEW_SEQ_GENERATOR",
	        sequenceName = "VIEW_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIEW_SEQ_GENERATOR")
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
