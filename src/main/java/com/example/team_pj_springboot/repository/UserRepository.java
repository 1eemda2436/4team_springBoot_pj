package com.example.team_pj_springboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.team_pj_springboot.entities.Member;

public interface UserRepository extends JpaRepository<Member, String>{
	
//	Optional<User> findByLogin(String login);

}
