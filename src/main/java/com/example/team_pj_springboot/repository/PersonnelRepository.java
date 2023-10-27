package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.team_pj_springboot.dto.PersonnelMemberDTO;

public interface PersonnelRepository extends JpaRepository<PersonnelMemberDTO, String> {
	
	@Modifying
	@Query("UPDATE MemberDTO m SET m.depart_id = :depart_id, m.team_id = :team_id, m.name = :name, m.tel = :tel WHERE m.id = :id")
	void updatePersonnel(@Param("id") String id, @Param("depart_id") int depart_id, @Param("team_id") Integer team_id, @Param("name") String name, @Param("tel") String tel);

}