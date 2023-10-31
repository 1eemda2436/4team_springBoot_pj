package com.example.team_pj_springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.team_pj_springboot.repository.ProjectRepository;
import com.example.team_pj_springboot.dto.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {

   @Autowired
   private ProjectRepository dao;

   @Override
   public List<ProjectDTO> listAll(int team_id) {
      // TODO Auto-generated method stub
      return dao.findProject(team_id);
   }

   @Override
   public void save(ProjectDTO dto) {
      // TODO Auto-generated method stub
      dao.save(dto);
   }

   @Override
   public ProjectDTO get(int pj_id) {
      // TODO Auto-generated method stub
      return dao.findById(pj_id).get();
   }

   @Override
   public void delete(int pj_id) {
      // TODO Auto-generated method stub
      dao.deleteById(pj_id);
   }
   
   // 프로젝트 업데이트 show
   @Transactional
   public void updateShow(int pj_id) {
      dao.updateShow(pj_id);
   }
   
//   // List
//   @Override
//   public List<ProjectDTO> listAll(HttpServletRequest req, Model model) {
//      return dao.findAll();
//   }
//
//   // Insert : PK가 존재하지 않을때는 신규, PK가 존재할 때는 해당키의 데이터를 update
//   @Override
//   public void save(ProjectDTO dto)
//         throws ServletException, IOException {
//      dao.save(dto);
//   }
//
//   @Override
//   public ProjectDTO get(int pj_id) 
//         throws ServletException, IOException {
//      return dao.findById(pj_id).get();
//   }
//
//   @Override
//   public void delete(int pj_id)
//         throws ServletException, IOException {
//      dao.deleteById(pj_id);
//      
//   }

}