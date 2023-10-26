package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "qna")
@Data
public class QnADTO {
	
	@Id
	private int qna_id;
    private String question;
    private String answer;
    private Timestamp date_added;

}
