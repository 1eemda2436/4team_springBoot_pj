package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.ProjectProgressBarDTO;

@Mapper
public interface ProjectProgressBarMapper {
	
	public List<ProjectProgressBarDTO> pjProgressBar (int team_id);

}
