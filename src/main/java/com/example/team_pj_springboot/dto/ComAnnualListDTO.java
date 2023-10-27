package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComAnnualListDTO {
	
	@Id
	private String	company_id;			// 전사 id
    private int 	annual_id;			// 글 번호
    private String 	annual_title;		// 글 제목
    private String 	confirm;			// 승인여부

}
