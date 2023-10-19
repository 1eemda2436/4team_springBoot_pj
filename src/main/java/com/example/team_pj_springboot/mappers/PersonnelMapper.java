package com.example.team_pj_springboot.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonnelMapper {
	
	public int findMaxId();
	
}
