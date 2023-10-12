package com.example.team_pj_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{
	
//	public Optional<Company> findByEmail(String email);

}