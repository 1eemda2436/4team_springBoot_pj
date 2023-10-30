package com.example.team_pj_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.MemberDTO;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, String> {
	//   @Query("SELECT new com.example.team_pj_springboot.dto.CompanyDTO(c.companyId) " + 
	//         "FROM MemberDTO m " + 
	//         "JOIN CompanyDTO c ON c.companyId = m.company_id" +
	//         "WHERE m.id = :id ")
	//   Optional<CompanyDTO> findCompanyByUserId(@Param("id") String id);

	@Query("SELECT m.company_id " + 
			"FROM MemberDTO m " + 
			"WHERE m.id = :id ")
	Optional<String> findCompanyIdByUserId(@Param("id") String id);

	@Modifying
	@Query("UPDATE MemberDTO m SET m.rank = :rank, m.authority = 'ROLE_MANAGER' WHERE m.id = :id")
	void updateRank(@Param("id") String id, @Param("rank") String rank);
}
