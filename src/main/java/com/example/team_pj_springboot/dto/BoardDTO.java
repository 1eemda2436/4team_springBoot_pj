package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="board")
@Data
public class BoardDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", allocationSize = 1)
	private int board_id;
	private int category_id;
	private String id;
	private String title;
	private String content;
	private int hits;
	private int comment_cnt;
	private Date reg_date;
	private String board_file;
	
	public BoardDTO() {
        // 기본 생성자
    }
	
}
