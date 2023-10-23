package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.NoticeDTO;
import com.example.team_pj_springboot.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeRepository dao;
	
	@Override
	public List<NoticeDTO> listAll() {
		
		return dao.findAll();
	}

	@Override
	public void insertNotice(NoticeDTO dto) {
		dao.save(dto);
	}

	@Override
	public void updateNotice(NoticeDTO dto) {
		dao.save(dto);
	}

	@Override
	public void deleteNotice(int notice_id) {
		dao.deleteById(notice_id);
	}

}
