package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.dto.DepAttendanceDTO;
import com.example.team_pj_springboot.repository.AttendanceRepository;
import com.example.team_pj_springboot.repository.DepartmentRepository;
import com.example.team_pj_springboot.repository.MemberRepository;

@Service
public class DepAttenService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private MemberRepository memberRepository;

    public List<DepAttendanceDTO> getYourData() {
        String jpql = "SELECT new com.example.team_pj_springboot.dto.YourResultDTO(D.depart_id, D.depart_name, M.name, MA.general_workin, MA.general_workout, MA.holiday_name, MA.gived_holiday) " +
                     "FROM MemberDTO M " +
                     "JOIN AttendanceDTO MA ON M.id = MA.id " +
                     "JOIN DepartmentDTO D ON M.depart_id = D.depart_id " +
                     "WHERE D.depart_id = 1 " +
                     "ORDER BY D.depart_id, M.name";

        return entityManager.createQuery(jpql, DepAttendanceDTO.class).getResultList();
    }
}

//@Autowired
//private DepartmentRepository departmentRepository;
//
//@Autowired
//public DepAttenService(DepartmentRepository departmentRepository) {
//	this.departmentRepository = departmentRepository;
//}
//
//@Transactional
//public Optional<DepAttendanceDTO> departmentAttendanceStatus (int depart_id) {
//	return departmentRepository.departmentAttendanceStatus(depart_id);
//}