package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import com.example.team_pj_springboot.dto.CompanyDTO;

public interface CompanyService {

	//Company Main
	public Optional<CompanyDTO> main(String companyId);
	
}
