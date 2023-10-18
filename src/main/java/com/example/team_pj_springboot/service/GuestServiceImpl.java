package com.example.team_pj_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.AnnualDTO;
import com.example.team_pj_springboot.dto.VacationDTO;
import com.example.team_pj_springboot.repository.AnnualRepository;
import com.example.team_pj_springboot.repository.VacationRepository;

@Service
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private AnnualRepository adao;
	
	@Autowired
	private VacationRepository vdao;

	@Override
	public void annualInsert(AnnualDTO dto) {
		adao.save(dto);
	}

	@Override
	public void vacationInsert(VacationDTO dto) {
		vdao.save(dto);
	}

	
}
