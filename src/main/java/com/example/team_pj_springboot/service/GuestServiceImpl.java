package com.example.team_pj_springboot.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.mappers.AttenMapper;
import com.example.team_pj_springboot.repository.AnnualRepository;
import com.example.team_pj_springboot.repository.VacationRepository;

@Service
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private AttenMapper dao;

	@Override
	public int annualInsert(AnnualDTO dto) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - annualInsert ]");
		
		int annualCnt = dao.insertAnnual(dto);
		
		return annualCnt;
	}

	@Override
	public int vacationInsert(VacationDTO dto) throws ServletException, IOException {
		System.out.println("[ GuestServiceImpl - vacationInsert ]");
		
		int vacatCnt = dao.insertVacation(dto);
		
		return vacatCnt;
	}
	
}
