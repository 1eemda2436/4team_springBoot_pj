package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="board_category")
@Data
public class BoardCategoryDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardcategory_seq")
	@SequenceGenerator(name = "boardcategory_seq", sequenceName = "boardcategory_seq", allocationSize = 1)
	private int category_id;
	private String category_name;
	
}
