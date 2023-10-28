package com.example.team_pj_springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.AllPersonnelDTO;

@Mapper
public interface PersonnelMapper {
	
	public int findMaxId();
	
	public List<AllPersonnelDTO> findPersonnelMembersWithDetails(String company_id);
	
	public AllPersonnelDTO myInfo(String id);
}
