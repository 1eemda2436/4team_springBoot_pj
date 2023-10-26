package com.example.team_pj_springboot.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.MemberDTO;


@Mapper
public interface UserMapper {
	MemberDTO toMemberDTO(MemberDTO user);
}
