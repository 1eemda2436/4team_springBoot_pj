package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="board_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
	@SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", allocationSize = 1)
	private int comment_id;
	private int board_id;
	private int writer;
	private String content;
	private Date reg_date;

}
