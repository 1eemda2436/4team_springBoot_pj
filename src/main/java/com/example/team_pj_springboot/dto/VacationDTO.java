package com.example.team_pj_springboot.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="vacation_board")
@Data
public class VacationDTO {
	
	@Id
    private int 	vacation_id;			// 글 번호
    private String 	id;						// 사원번호
    private String	name;					// 이름
    private String 	vacation_title;			// 글 제목
    private Date	vacation_start;			// 휴가 시작날짜
    private Date	vacation_end;			// 휴가 종료날짜
    private String 	vacation_content;		// 글 내용
    private Date 	vacation_reg_date;		// 작성 일자
    private String 	confirm;				// 승인여부
    private String	company_id;				// 전사 id
}
