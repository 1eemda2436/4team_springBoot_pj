package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
@DynamicInsert
@Data
public class TeamDTO {
    @Id
    @SequenceGenerator(name = "team_seq_generator", sequenceName = "TEAM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_generator")
    private int team_id;    // 팀 id
    private String team_name;    // 팀명
    private int depart_id;    // 부서 id (FK)
    private char show = 'Y';   // 공개 여부
}

