package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.ProjectWorkDTO;

// 프로젝트 업무 repository
public interface ProjectWorkRepository extends JpaRepository<ProjectWorkDTO, Integer> {
	
	// 프로젝트 별 업무 SELECT
	@Query("SELECT pw FROM ProjectWorkDTO pw WHERE pw.pj_id = :pj_id ")
	List<ProjectWorkDTO> findProjectWork(@Param("pj_id") int pj_id);
	
	// 프로젝트 업무 COMPLETE 여부 업데이트
	@Modifying
    @Query("UPDATE ProjectWorkDTO pw SET pw.complete = :complete WHERE pw.pw_id = :pw_id")
    void updateComplete(@Param("pw_id") int pw_id, @Param("complete") String complete);
}
