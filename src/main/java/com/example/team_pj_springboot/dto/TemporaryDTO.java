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
@Table(name="doc_save")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class TemporaryDTO {

	@Id
	@SequenceGenerator(
	        name = "TEMPORARY_SEQ_GENERATOR",
	        sequenceName = "TEMPORARY_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMPORARY_SEQ_GENERATOR")
	private int save_id;
	private int doc_id;
	private String id;
	private Date save_date;
	private String doc_title;
}
