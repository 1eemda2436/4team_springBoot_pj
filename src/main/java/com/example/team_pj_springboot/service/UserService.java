package com.example.team_pj_springboot.service;

import java.nio.CharBuffer;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.JoinDTO;
import com.example.team_pj_springboot.dto.LoginDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.TeamDTO;
import com.example.team_pj_springboot.dto.UserRoleDTO;
import com.example.team_pj_springboot.exception.AppException;
import com.example.team_pj_springboot.mappers.UserMapper;
import com.example.team_pj_springboot.repository.CompanyRepository;
import com.example.team_pj_springboot.repository.DepartmentRepository;
import com.example.team_pj_springboot.repository.MemberRepository;
import com.example.team_pj_springboot.repository.TeamRepository;
import com.example.team_pj_springboot.repository.UserRoleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final CompanyRepository companyRepository;
	private final DepartmentRepository departmentRepository;
	private final TeamRepository teamRepository;
	private final MemberRepository memberRepository;
	private final UserRoleRepository userRoleRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	public MemberDTO findById(String id) {
		System.out.println("UserService - findById()");

		MemberDTO memberDTO = memberRepository.findById(id)
				.orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));

		return userMapper.toMemberDTO(memberDTO);
	}

	public MemberDTO login(LoginDTO loginDTO) {
		System.out.println("UserService - login()");

		MemberDTO member = memberRepository.findById(loginDTO.getId())
				.orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));

		// 비밀번호 인코더를 사용하여 비밀번호가 일반 텍스트로 저장되는 것을 방지하지만 해시된 비밀번호는 읽을 수 없다.
		// import java.nio.CharBuffer; 주의
		if(passwordEncoder.matches(CharBuffer.wrap(loginDTO.getPwd()), member.getPwd())) {
			return member;
		}

		throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
	}

	@Transactional
	public JoinDTO companyJoin(JoinDTO joinDTO) {

		System.out.println("UserService - join()");

		System.out.println(joinDTO);

		CompanyDTO company = new CompanyDTO();
		company.setCompanyId(joinDTO.getCompanyDTO().getCompanyId());
		company.setName(joinDTO.getCompanyDTO().getName());
		company.setAddress(joinDTO.getCompanyDTO().getAddress());
		company.setEmployees(joinDTO.getCompanyDTO().getEmployees());
		company.setManager(joinDTO.getCompanyDTO().getManager());
		company.setEmail(joinDTO.getCompanyDTO().getEmail());
		company.setWork_in(joinDTO.getCompanyDTO().getWork_in());
		company.setWork_out(joinDTO.getCompanyDTO().getWork_out());
		company.setKey(joinDTO.getCompanyDTO().getKey());
		company.setEnabled(joinDTO.getCompanyDTO().getEnabled());

		CompanyDTO saveCompany = companyRepository.save(company);
		System.out.println(saveCompany);


		DepartmentDTO department = new DepartmentDTO();
		department.setCompany_id(saveCompany.getCompanyId());
		department.setDepart_name("임시 부서");

		DepartmentDTO saveDepartment = departmentRepository.save(department);
		System.out.println(saveDepartment);


		TeamDTO team = new TeamDTO();
		team.setDepart_id(saveDepartment.getDepart_id());
		team.setTeam_name("임시 팀");

		TeamDTO saveTeam = teamRepository.save(team);
		System.out.println(saveTeam);


		MemberDTO member = new MemberDTO();
		member.setId(joinDTO.getMemberDTO().getId());
		member.setPwd(passwordEncoder.encode(CharBuffer.wrap(joinDTO.getMemberDTO().getPwd())));
		member.setName(saveCompany.getManager());
		member.setCompany_id(saveCompany.getCompanyId());
		member.setEmail(saveCompany.getEmail());
		member.setKey(saveCompany.getKey());
		member.setAuthority("ROLE_ADMIN");
		member.setEnabled(saveCompany.getEnabled());
		member.setDepart_id(saveDepartment.getDepart_id());
		member.setTeam_id(saveTeam.getTeam_id());

		MemberDTO saveManager = memberRepository.save(member);
		System.out.println(saveManager);

		JoinDTO saveJoin = new JoinDTO();

		saveJoin.setCompanyDTO(saveCompany);
		saveJoin.setDepartmentDTO(saveDepartment);
		saveJoin.setTeamDTO(saveTeam);
		saveJoin.setMemberDTO(saveManager);

		return saveJoin;
	}
	
	@Transactional
	public void userRole(UserRoleDTO roleDTO) {
		System.out.println(roleDTO);
		userRoleRepository.save(roleDTO);
		memberRepository.updateRank(roleDTO.getId(), roleDTO.getRank());
	} 

}