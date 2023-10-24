package com.example.team_pj_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.DepartmentListDTO;
import com.example.team_pj_springboot.repository.DepartmentRepository;

@Service
public class DepartmentListServiceImpl implements DepartmentListService {

	@Autowired
   private DepartmentRepository dao;
	
	@Override
	public List<Object[]> listAll() {
		return dao.departList();
	}

}
