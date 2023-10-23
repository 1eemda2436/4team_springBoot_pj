package com.example.team_pj_springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocAndDraftDTO;
import com.example.team_pj_springboot.dto.DocAndTemporaryDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;
import com.example.team_pj_springboot.service.DocService;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping("/guest/doc")
public class DocController {

   private static final Logger logger = LoggerFactory.getLogger(DocController.class);
   
   @Autowired
   private DocService service;
   
   // 게스트메인 - 연결완료
   @GetMapping("/guestTotal")
   public List<DocAndDraftDTO> selectGuest() {
      logger.info("<<< 컨트롤러 - selectMember >>>");
      
      return service.draftList();
   }
   
   // 기안문서함 - 연결완료
   @GetMapping("/draft")
   public List<DocAndDraftDTO> draftList() {
      logger.info("<<< 컨트롤러 - draftList >>>");
      
      return service.draftList();
   }
   
   // 회람문서함 - 연결완료
   @GetMapping("/view")
   public List<DocDTO> viewList() {
      logger.info("<<< 컨트롤러 - viewList >>>");
      
      return service.viewList();
   }
   
   // 임시저장목록 - 연결완료
   @GetMapping("/temporary")
   public List<DocAndDraftDTO> temporaryList() {
      logger.info("<<< 컨트롤러 - temporaryList >>>");
      
      return service.temporaryList();
   }
   
   // 임시저장
   @PostMapping("/temporarySave")
   public List<DocAndDraftDTO> insertTemporary(@RequestParam("doc_attachment2") MultipartFile file, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - temporarySave >>>");
      
      try {
              // 파일 업로드하고 파일 경로를 받아옴
              String filePath = service.uploadFile(file);
              System.out.println("file: " + file);

              // DTO 객체에 파일 경로 설정
              dto.setDoc_attachment(filePath);
              System.out.println("filePath: " + filePath);

              // 서비스로 DTO 객체 전달하여 저장
              service.insertDoc(dto);
             } catch (IOException e) {
              // 파일 업로드 중 예외가 발생할 경우 처리
              e.printStackTrace();
             }
      
      return service.temporaryList();
   }
   
   
   // 문서작성페이지 - 연결완료
   @PostMapping("/insert")
   public String insertDoc(@RequestParam("doc_attachment2") MultipartFile file, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - insertDoc >>>");
      
      try {
              // 파일 업로드하고 파일 경로를 받아옴
              String filePath = service.uploadFile(file);
              System.out.println("file: " + file);

              // DTO 객체에 파일 경로 설정
              dto.setDoc_attachment(filePath);
              System.out.println("filePath: " + filePath);

              // 서비스로 DTO 객체 전달하여 저장
              service.insertDoc(dto);
             } catch (IOException e) {
              // 파일 업로드 중 예외가 발생할 경우 처리
              e.printStackTrace();
             }
      
      return "redirect:/";
   }
   
   // 문서수정페이지 - 진행중
   @PutMapping("/update/{doc_id}")
   public void updateDoc(@PathVariable(name="doc_id") int doc_id, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.updateDoc(doc_id, dto);
      
   }

    
   // 문서상세페이지 - 연결완료
   @GetMapping("/detail/{doc_id}")
   public Optional<DocAndCategoryDTO> selectDoc(@PathVariable int doc_id) {
      logger.info("<<< 컨트롤러 - selectDoc >>>");
      logger.info("doc_id: " + doc_id);
      
      Optional<DocAndCategoryDTO> dto = service.selectDoc(doc_id);
      
      return dto;
   }
   
   // 문서삭제페이지 포스트맨성공
   @DeleteMapping("/delete/{doc_id}")
   public void deleteDoc(@PathVariable(name="doc_id") int doc_id, Model model) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.deleteDoc(doc_id); 
      
   }
   
}   