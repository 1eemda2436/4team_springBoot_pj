package com.example.team_pj_springboot.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.ProjectDTO;
import com.example.team_pj_springboot.dto.ProjectWorkDTO;

// 프로젝트 repository
public interface ProjectRepository extends JpaRepository<ProjectDTO, Integer> {

   // 프로젝트 SELECT
   @Query("SELECT p FROM ProjectDTO p WHERE p.team_id = :team_id AND show = 'Y' ")
   List<ProjectDTO> findProject(@Param("team_id") int team_id);
   
   //프로젝트 shoe
   @Modifying
   @Query("UPDATE ProjectDTO SET show='N' WHERE pj_id = :pj_id")
   void updateShow (@Param("pj_id") int pj_id);
   
}