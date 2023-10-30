package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.DocDTO;

@Mapper
public interface DocMapper {
	
	public DocDTO docChart (String company_id);

}
