package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="annual_board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnnualDTO {
	
	@Id
    private int 	annual_id;			// 글 번호
    private String 	id;					// 사원번호
    private String	name;				// 이름
    private String 	annual_title;		// 글 제목
    private Date	annual_start;		// 연차 시작날짜
    private Date	annual_end;			// 연차 종료날짜
    private String 	annual_content;		// 글 내용
    private Date 	annual_reg_date;	// 작성 일자
    private String 	confirm;			// 승인여부
    
}
