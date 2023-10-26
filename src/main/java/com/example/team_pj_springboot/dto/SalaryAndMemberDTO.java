package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class SalaryAndMemberDTO {
	
	@Id
    private int s_id;			//순번
    private String id;			//사번
    private String name;		//이름
    private int resident;		//주민번호
    private String contract;	//계약형태
    private int depart_id;		//부서ID
    private String rank;		//직급
    private char state;			//사원 업무상태 (1-업무중 / 2-외출 / 3-비활성화)
    private char estate;		//재직여부(1-재직, 0-퇴사)
    private int salary;			//기본급
}
