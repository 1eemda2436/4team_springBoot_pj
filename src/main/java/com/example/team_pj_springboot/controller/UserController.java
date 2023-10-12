package com.example.team_pj_springboot.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.config.UserAuthProvider;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.JoinDTO;
import com.example.team_pj_springboot.dto.LoginDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.service.UserService;


@RequiredArgsConstructor // 생성자에 멤버변수를 주입
@RestController  // 리턴할때 주소값을 안넘겨도 에러가 안나고 실제 데이터가 넘어감
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;
	private final UserAuthProvider userAuthProvider;

	@PostMapping({"", "/"})
	public ResponseEntity<MemberDTO> login(@RequestBody LoginDTO loginDTO) {
		System.out.println("<<< AuthController - login() >>>");

		MemberDTO member = userService.login(loginDTO);

		System.out.println("token : " + userAuthProvider.createToken(member.getId()));
		userAuthProvider.createToken(member.getId());

		return ResponseEntity.ok(member);   // 크롬 Network - Headers : 200 OK 새로운 JWT를 반환
	}

	@PostMapping("/join")
	public ResponseEntity<CompanyDTO> Companyjoin(@RequestBody JoinDTO joinDTO) {
	    System.out.println("<<< AuthController - register() >>>");

	    // 엔티티를 생성할 때 새 엔티티를 찾을 수 있는 URL과 함께 201HTTP 코드를 반환하는 것이 가장 좋다.
	    CompanyDTO companyDTO = userService.companyJoin(joinDTO);//리액트에서 넘어온 정보 + 토큰 → 토큰 insert
	    
	    return ResponseEntity.created(URI.create("/company/" + companyDTO.getCompany_id()))
	            .body(companyDTO); //크롬 Network - Headers : 201Created 반환
	}
}

