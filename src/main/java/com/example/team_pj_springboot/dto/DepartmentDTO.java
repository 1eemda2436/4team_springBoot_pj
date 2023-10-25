package com.example.team_pj_springboot.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
@DynamicInsert
@Data
public class DepartmentDTO {
    @Id
    @SequenceGenerator(name = "department_seq_generator", sequenceName = "DEPARTMENT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq_generator")
    private int depart_id;        // 부서 id
    private String depart_name;   // 부서명
    private String company_id;    // 회사 id (FK)
    private char show = 'Y';      // 공개여부
    
    @Transient
    private int teamCount;		//팀 갯수
}

