package com.example.team_pj_springboot.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "project")
@Data
public class ProjectDTO {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_SEQ")
   @SequenceGenerator(name = "PROJECT_SEQ", sequenceName = "PROJECT_SEQ", allocationSize = 1)
   private Integer pj_id;
   private String pj_name;
   private String content;
   private Date deadline_s;
   private Date deadline_e;
   private Integer team_id;
   private String show;

}