package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="doc_category")
@Data
public class CategoryDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int category_id;
	private String category_name;
	 
}
