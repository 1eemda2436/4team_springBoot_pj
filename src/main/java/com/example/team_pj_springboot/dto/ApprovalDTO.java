package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="doc_approval")
@Data
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDTO {
	
	@Id
	@SequenceGenerator(
	        name = "APPROVAL_SEQ_GENERATOR",
	        sequenceName = "APPROVAL_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPROVAL_SEQ_GENERATOR")
	private int approval_id;
	private String approval_name;
	private int doc_id;
	private String approval_content;
	private Date approval_date;
	private Date approval_endDate;
	private String doc_status;
	private int category_id;
	private String id;
	private String name;
	
}
