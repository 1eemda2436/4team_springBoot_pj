package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.service.DocService;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/admin/doc")
public class ApprovalController {
   
   private static final Logger logger = LoggerFactory.getLogger(DocController.class);
   
   @Autowired
   private DocService service;
   
   // http://localhost:8081/doc/adminTotal
   // 어드민메인 - 연결완료
   @GetMapping("/adminTotal")
   public List<ApprovalIngAndDocDTO> selectAdmin() {
      logger.info("<<< 컨트롤러 - selectMember >>>");
      
      return service.approvalAllList();
   }
      
   // 결재완료문서함 - 연결완료
   @GetMapping("/approvalEnd")
   public List<ApprovalEndAndDocDTO> approvalEndList() {
      logger.info("<<< 컨트롤러 - approvalEndList >>>");
      
      return service.approvalEndList();
   }
   
   // 결재예정문서함 - 연결완료
   @GetMapping("/approvalIng")
   public List<ApprovalIngAndDocDTO> approvalIngList() {
      logger.info("<<< 컨트롤러 - approvalIngList >>>");
      
      return service.approvalIngList();
   }
      
   // 결재반려문서함 - 연결완료
   @GetMapping("/approvalBack")
   public List<ApprovalBackAndDocDTO> approvalBackList() {
      logger.info("<<< 컨트롤러 - approvalBackList >>>");
      
      return service.approvalBackList();
   }
   
   // 결재문서상세페이지
   @GetMapping("/adminDetail/{doc_id}")
   public Optional<DocDTO> selectApp(@PathVariable int doc_id) {
      logger.info("<<< 컨트롤러 - selectApp >>>");
      logger.info("doc_id: " + doc_id);
      
      Optional<DocDTO> dto = service.selectApp(doc_id);
      
      return dto;
   }
   
   // 문서수정페이지 - 연결완료
   @PutMapping("/update/{doc_id}")
   public void updateDoc(@PathVariable(name="doc_id") int doc_id, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      
      service.updateDoc(doc_id, dto);
      
   }
   
   // 결재완료용 수정페이지
   @PutMapping("/updateEnd/{doc_id}")
   public void updateEndDoc(@PathVariable(name="doc_id") int doc_id, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.updateEndStatus(doc_id, dto);
      
   }
   
   // 결재반려용 수정페이지
   @PutMapping("/updateBack/{doc_id}")
   public void updateBackDoc(@PathVariable(name="doc_id") int doc_id, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.updateBackStatus(doc_id, dto);
      
   }
   
   // 관리자사인등록
   @PostMapping("/insert")
   public String insertDoc(@RequestParam("admin_sign1") MultipartFile admin_sign1, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - insertDoc >>>");
      System.out.println("컨트로러럴 " + admin_sign1);
      System.out.println("컨트로러럴 2" + dto.getAdmin_sign());
      System.out.println("dto : " + dto);
      
      try {
              // 파일 업로드하고 파일 경로를 받아옴
              String filePath = service.uploadImageFile(admin_sign1);
              System.out.println("sign : " + admin_sign1);

              // DTO 객체에 파일 경로 설정
              dto.setAdmin_sign(filePath);
              System.out.println("filePath: " + filePath);

              // 서비스로 DTO 객체 전달하여 저장
              service.insertDoc(dto);
             } catch (IOException e) {
              // 파일 업로드 중 예외가 발생할 경우 처리
              e.printStackTrace();
             }
      
      return "redirect:/";
   }
 
}