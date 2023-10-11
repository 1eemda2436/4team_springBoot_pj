package com.example.team_pj_springboot.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.entities.Company;
import com.example.team_pj_springboot.entities.Member;


@Mapper
public interface UserMapper {

	MemberDTO toMemberDTO(Member user);
	
	Company signUpToUser(CompanyDTO companyDTO);
}
