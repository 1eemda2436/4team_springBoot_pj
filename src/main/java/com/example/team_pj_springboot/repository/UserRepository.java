package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.team_pj_springboot.entities.Member;

public interface UserRepository extends JpaRepository<Member, String>{

}