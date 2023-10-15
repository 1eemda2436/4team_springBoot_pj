package com.example.team_pj_springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
//	public Optional<CompanyDTO> findCompanyById(String id) {
//        return companyRepository.findById(id);
//    };
	
	@Override
	public Optional<CompanyDTO> main(String companyId){
		return companyRepository.findById(companyId);
	}

	
}
