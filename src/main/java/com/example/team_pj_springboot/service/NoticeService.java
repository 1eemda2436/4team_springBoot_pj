package com.example.team_pj_springboot.service;

import java.util.List;

import com.example.team_pj_springboot.dto.NoticeDTO;

public interface NoticeService {
	
	public List<NoticeDTO> listAll();
	public void insertNotice(NoticeDTO dto);
	public void updateNotice(NoticeDTO dto);
	public void deleteNotice(int notice_id);

}
