package com.example.team_pj_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.CompanyDTO;


public interface CompanyRepository extends JpaRepository<CompanyDTO, String>{

	//Object findByCompanyid(String companyid);
	
	public Optional<CompanyDTO> findByCompanyId(String companyId);

}