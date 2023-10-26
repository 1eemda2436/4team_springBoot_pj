package com.example.team_pj_springboot.dto;

import java.sql.Date;

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
@Table(name="doc_category")
@Data
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	@Id
	@SequenceGenerator(
	        name = "CATEGORY_SEQ_GENERATOR",
	        sequenceName = "CATEGORY_SEQ",
	        allocationSize = 1
	    )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ_GENERATOR")
	private int category_id;
	private String category_name;
	 
}
