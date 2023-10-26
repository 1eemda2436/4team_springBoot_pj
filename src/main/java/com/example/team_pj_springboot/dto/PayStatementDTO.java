package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class PayStatementDTO {
	
	@Id
	private int s_id;			//순번
    private String id;			//사번
    private String name;		//이름
    private String rank;		//직급
    private int salary; 		// 기본급
    private int income_tax; 	// 소득세
    private int local_tax; 		// 지방소득세
    private int national_pension; 	// 국민연금
    private int health_insurance; 	// 건강보험
    private int c_health_insurance; // 장기요양건강보험
    private int employment_insurance; // 고용보험
    private int bonus; 			// 보너스, 상여
    private int allowance; 		// 연차수당
    private int overtime_pay; 	// 야근수당
    private int food_pay; 		// 식비
    private int t_pay; 			// 교통비
    private int amount_money; 	// 지급액
    private int amount_tax; 	// 공제계
}
