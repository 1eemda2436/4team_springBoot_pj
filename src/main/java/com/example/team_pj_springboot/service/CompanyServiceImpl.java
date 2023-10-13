package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyRepository companyRepository;
	
	@Override
	public CompanyDTO main(String company_id){
		System.out.println(company_id);
		return companyRepository.findByCompany_id(company_id).get();
	}

	
}
