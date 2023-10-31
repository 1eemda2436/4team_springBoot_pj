package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.DocProgressBarDTO;

@Mapper
public interface DocMapper {
	
	public DocProgressBarDTO docChart (String company_id);

}
