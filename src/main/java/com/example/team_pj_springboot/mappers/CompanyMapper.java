package com.example.team_pj_springboot.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
	
	public int findMaxId();
	
}
