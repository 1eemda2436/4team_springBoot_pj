package com.example.team_pj_springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.team_pj_springboot.dto.DepartmentDTO;
import com.example.team_pj_springboot.dto.TeamDTO;

@Repository
public interface TeamRepository extends JpaRepository<TeamDTO, Integer> {
   @Query("SELECT t FROM TeamDTO t WHERE t.depart_id = :depart_Id AND t.show = 'Y' ")
    List<TeamDTO> findTeamsByDepartId(@Param("depart_Id") int depart_id);

   @Modifying
   @Transactional
   @Query("UPDATE TeamDTO t SET t.show='N' WHERE t.team_id = :team_id")
   void teamDeleteUpdate(@Param("team_id")int team_id);

}