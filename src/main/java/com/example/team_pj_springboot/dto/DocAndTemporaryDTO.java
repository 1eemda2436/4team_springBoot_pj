package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class DocAndTemporaryDTO {

	@Id
	private int doc_id;
	private String doc_title;
	private Date save_date;
}
