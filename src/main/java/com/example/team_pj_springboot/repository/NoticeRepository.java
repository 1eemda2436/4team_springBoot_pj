package com.example.team_pj_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.NoticeDTO;

public interface NoticeRepository extends JpaRepository<NoticeDTO, Integer>{

	@Query("SELECT n FROM NoticeDTO n WHERE n.notice_id = :notice_id")
	List<NoticeDTO> findNoticeByNoticeID(@Param("notice_id") int notice_id);
}
