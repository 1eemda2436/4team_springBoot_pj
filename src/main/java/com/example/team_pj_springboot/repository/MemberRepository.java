package com.example.team_pj_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.team_pj_springboot.dto.MemberDTO;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, String> {
	@Modifying
    @Query("UPDATE MemberDTO m SET m.rank = :rank, m.authoriry = 'ROLE_MANAGER' WHERE m.id = :id")
    void updateRank(@Param("id") String id, @Param("rank") String rank);
}
