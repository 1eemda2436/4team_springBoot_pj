package com.example.team_pj_springboot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.example.team_pj_springboot.dto.AllPersonnelDTO;
import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDoc2DTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocAndDraftDTO;
import com.example.team_pj_springboot.dto.DocAndTemporaryDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.DocProgressBarDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.PersonnelMemberDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;
import com.example.team_pj_springboot.service.DocService;
import com.example.team_pj_springboot.service.PersonnelService;

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
   
   // 임시저장 - 연결완료
   @PostMapping("/temporarySave")
   public List<DocAndDraftDTO> insertTemporary(@RequestParam("doc_attachment2") MultipartFile file, @RequestParam("sign2") MultipartFile sign, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - temporarySave >>>");
      
      try {
              // 파일 업로드하고 파일 경로를 받아옴
              String filePath = service.uploadFile(file);
              System.out.println("file: " + file);
              String filePath2 = service.uploadImageFile(sign);
              System.out.println("sign : " + sign);

              // DTO 객체에 파일 경로 설정
              dto.setDoc_attachment(filePath);
              System.out.println("filePath: " + filePath);
              dto.setSign(filePath2);
              System.out.println("filePath2: " + filePath2);

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
   public String insertDoc(@RequestParam("doc_attachment2") MultipartFile file, @RequestParam("sign2") MultipartFile sign, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - insertDoc >>>");
      
      try {
              // 파일 업로드하고 파일 경로를 받아옴
              String filePath = service.uploadFile(file);
              String filePath2 = service.uploadImageFile(sign);
              System.out.println("file : " + file);
              System.out.println("sign : " + sign);

              // DTO 객체에 파일 경로 설정
              dto.setDoc_attachment(filePath);
              dto.setSign(filePath2);
              System.out.println("filePath: " + filePath);
              System.out.println("filePath2: " + filePath2);

              // 서비스로 DTO 객체 전달하여 저장
              service.insertDoc(dto);
             } catch (IOException e) {
              // 파일 업로드 중 예외가 발생할 경우 처리
              e.printStackTrace();
             }
      
      return "redirect:/";
   }
   
   // 파일 다운로드 - 연결완료
   @GetMapping("/download/{fileName:.+}") // download뒤에 원하는 파일이름 입력, 뒤에 .+는 확장자
   public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws IOException {
	   logger.info("<<< 컨트롤러 - downloadFile >>>");
	   
	   // 파일 경로 설정 (doc_attachment 기준)
       String filePath = "./src/main/webapp/resources/upload/" + fileName;

       // 파일을 byte 배열로 읽어오기
       Path path = Paths.get(filePath);
       byte[] fileContent = Files.readAllBytes(path);
       
       // 응답 헤더 설정 (파일 다운로드를 위한 설정)
       HttpHeaders headers = new HttpHeaders();
       // 다운로드할 파일이 바이너리 파일임을 나타내기 위해 APPLICATION_OCTET_STREAM 사용
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       headers.setContentLength(fileContent.length);
       // 브라우저에게 파일을 다운로드하라는 헤더 설정
       headers.setContentDispositionFormData("attachment", fileName); // 다운로드되는 파일명 설정
       
       return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
   }
   
   
   
   // 문서수정페이지 - 연결완료
   @PutMapping("/update/{doc_id}")
   public void updateDoc(@PathVariable(name="doc_id") int doc_id, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.updateDoc(doc_id, dto);
      
   }
   
   // 결재요청용 수정페이지
   @PutMapping("/updateIng/{doc_id}")
   public void updateIngDoc(@PathVariable(name="doc_id") int doc_id, @ModelAttribute DocDTO dto) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.updateIngStatus(doc_id, dto);
      
   }
    
   // 문서상세페이지 - 연결완료
   @GetMapping("/detail/{doc_id}")
   public Optional<DocAndCategoryDTO> selectDoc(@PathVariable int doc_id) {
      logger.info("<<< 컨트롤러 - selectDoc >>>");
      logger.info("doc_id: " + doc_id);
      
      Optional<DocAndCategoryDTO> dto = service.selectDoc(doc_id);
      
      return dto;
   }
   
   // 문서삭제페이지 - 연결완료
   @DeleteMapping("/delete/{doc_id}")
   public void deleteDoc(@PathVariable(name="doc_id") int doc_id, Model model) {
      logger.info("<<< 컨트롤러 - updateDoc >>>");
      
      service.deleteDoc(doc_id); 
      
   }
   
   // 결재요청목록
   @GetMapping("/approvalSelect")
   public List<ApprovalIngAndDoc2DTO> approvalIngList2() {
      logger.info("<<< 컨트롤러 - approvalIngList >>>");
      
      return service.approvalSelect();
   }

   // Doc Chart
   @GetMapping("/docChart/{company_id}")
   public DocProgressBarDTO docChart (@PathVariable String company_id, HttpServletRequest req, Model model)
		   throws ServletException, IOException {
	   System.out.println("[Controller → docChart]");
	   
	   return service.docChart(company_id, req, model);
   }

}   