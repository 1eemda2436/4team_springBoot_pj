package com.example.team_pj_springboot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.repository.ApprovalRepository;
import com.example.team_pj_springboot.repository.DocRepository;
import com.example.team_pj_springboot.repository.MemberRepository;
import com.example.team_pj_springboot.repository.TemporaryRepository;
import com.example.team_pj_springboot.repository.ViewRepository;
import com.example.team_pj_springboot.dto.ApprovalAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalBackAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalDTO;
import com.example.team_pj_springboot.dto.ApprovalEndAndDocDTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDoc2DTO;
import com.example.team_pj_springboot.dto.ApprovalIngAndDocDTO;
import com.example.team_pj_springboot.dto.CompanyDTO;
import com.example.team_pj_springboot.dto.DocAndCategoryDTO;
import com.example.team_pj_springboot.dto.DocAndDraftDTO;
import com.example.team_pj_springboot.dto.DocAndTemporaryDTO;
import com.example.team_pj_springboot.dto.DocDTO;
import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.TemporaryDTO;

@Service
public class DocServiceImpl implements DocService{
   
   @Autowired
   private DocRepository dao;
   
   @Autowired
    private TemporaryRepository temporaryDao;

    @Autowired
    private ApprovalRepository approvalDao;

    @Autowired
    private ViewRepository viewDao;
    
    @Autowired
    private MemberRepository memberDao;
    
    // 통합문서함
    @Override
   public MemberDTO selectMember(String id) {
       System.out.println("DocServiceImpl - selectMember");
       
      return memberDao.findById(id).get();
   }

   // 기안문서함
   @Override
   public List<DocAndDraftDTO> draftList() {
      System.out.println("DocServiceImpl - draftList");
      
      return dao.draftList();
   }

   // 회람문서함
   @Override
   public List<DocDTO> viewList() {
      System.out.println("DocServiceImpl - viewList");
      
      List<DocDTO> list= dao.findAll();
      System.out.println("list" + list);
      
      return list;
   }

   // 임시저장목록
   @Override
   public List<DocAndDraftDTO> temporaryList() {
      System.out.println("DocServiceImpl - temporaryList");
      
      return dao.temporaryList();
   }
   
   // 결재통합문서함
   @Override
   public List<ApprovalIngAndDocDTO> approvalAllList() {
	   System.out.println("DocServiceImpl - approvalAllList");
	   
	   return dao.approvalAllList();
   }

   // 결재완료문서함
   @Override
   public List<ApprovalEndAndDocDTO> approvalEndList() {
      System.out.println("DocServiceImpl - approvalEndList");
      
      return dao.ApprovalEndList();
   }

   // 결재예정문서함
   @Override
   public List<ApprovalIngAndDocDTO> approvalIngList() {
      System.out.println("DocServiceImpl - approvalIngList");
      
      return dao.approvalIngList();
   }
   
   // 결재요청목록
   @Override
   public List<ApprovalIngAndDoc2DTO> approvalSelect() {
      System.out.println("DocServiceImpl - approvalIngList");
      
      return dao.approvalSelect();
   }

   // 결재반려문서함
   @Override
   public List<ApprovalBackAndDocDTO> approvalBackList() {
      System.out.println("DocServiceImpl - approvalBackList");
      
      return dao.approvalBackList();
   }

   // 문서작성페이지
   @Override
   public DocDTO insertDoc(DocDTO dto) throws IOException{
      System.out.println("DocServiceImpl - insertDoc");
      
      // 현재 날짜를 가져와서 1년을 더한 날짜 계산
      LocalDate currentDate = LocalDate.now();
      LocalDate endDate = currentDate.plusYears(1);
       
      // endDate를 데이터베이스에 저장하기 위해 java.sql.Date로 변환
      java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);
       
      // DTO에 날짜 설정
      dto.setDoc_endDate(sqlEndDate); // 1년을 더한 날짜로 설정
      String id = dto.getId();
      
//      CompanyDTO companyDTO = memberDao.findCompanyByUserId(id).get();
//      dto.setCompany(companyDTO);
      String company_id = memberDao.findCompanyIdByUserId(id).orElse(null); //.get();
      dto.setCompany_id(company_id);       
      return dao.save(dto);
   }
   
      
   // 파일업로드
   @Override
   public String uploadFile(MultipartFile doc_attachment) throws IOException {
      
         String upload = "./src/main/webapp/resources/upload/";
               
      // 업로드 디렉토리가 존재하지 않으면 생성
      Files.createDirectories(Paths.get(upload));
      
      // 파일명
      String fileName = doc_attachment.getOriginalFilename();
      
      // 파일 저장 경로 설정
      Path filePath = Paths.get(upload + fileName);
      
      // 파일을 저장하고 파일명을 반환
      Files.write(filePath, doc_attachment.getBytes());
      
      return fileName;
   }
   
   
	// 이미지파일업로드
	@Override
	public String uploadImageFile(MultipartFile doc_attachment) throws IOException {
	   
	      String upload = "./src/main/resources/static/img/";
	            
	   // 업로드 디렉토리가 존재하지 않으면 생성
	   Files.createDirectories(Paths.get(upload));
	   
	   // 파일명
	   String fileName = doc_attachment.getOriginalFilename();
	   
	   // 파일 저장 경로 설정
	   Path filePath = Paths.get(upload + fileName);
	   
	   // 파일을 저장하고 파일명을 반환
	   Files.write(filePath, doc_attachment.getBytes());
	   
	   return fileName;
	}
	
	// 이미지 가져오기 및 Base64로 인코딩하여 클라이언트로 전송
   @GetMapping("/imageFile/{fileName:.+}")
   public ResponseEntity<String> getImageAsBase64(@PathVariable String fileName) throws IOException {
       // 이미지 파일을 읽어와서 Base64로 인코딩
       File imageFile = new File("./src/main/webapp/resources/upload/" + fileName);
       byte[] fileContent = Files.readAllBytes(imageFile.toPath());
       String base64Image = Base64.getEncoder().encodeToString(fileContent);
       
       // Base64로 인코딩된 이미지 데이터를 클라이언트로 전송
       return ResponseEntity.ok().body(base64Image);
	   }
   
   
   // 문서상세페이지
   @Override
   public Optional<DocAndCategoryDTO> selectDoc(int doc_id) {
      System.out.println("DocServiceImpl - selectDoc");
      
      return dao.selectOneDoc(doc_id);
   }
   
   // 결재문서상세페이지
   @Override
   public Optional<DocDTO> selectApp(int doc_id) {
      System.out.println("DocServiceImpl - selectApp");
      
      return dao.findById(doc_id);
   }

   // 문서수정페이지
   @Override
   public DocDTO updateDoc(int doc_id, DocDTO dto) {
      System.out.println("DocServiceImpl - updateDoc");
      
      // 문서 id를 사용해 해당 문서 찾기
      Optional<DocDTO> optionalDto = dao.findById(doc_id);
      if(optionalDto.isPresent()) {
         DocDTO realDto = optionalDto.get();
         
         // 기존 문서 업데이트
         realDto.setDoc_title(dto.getDoc_title());
         realDto.setDoc_content(dto.getDoc_content());
         realDto.setDoc_status(dto.getDoc_status());
         realDto.setApproval_content(dto.getApproval_content());
         realDto.setApproval_date(dto.getApproval_date());
         //realDto.setSign(dto.getSign());
         return dao.save(realDto);
      }
      
      return dao.findById(doc_id).get();
   }
   
   // 결재요청용 수정페이지
   @Override
   public DocDTO updateIngStatus(int doc_id, DocDTO dto) {
      System.out.println("DocServiceImpl - updateDoc");
      
      // 문서 id를 사용해 해당 문서 찾기
      Optional<DocDTO> optionalDto = dao.findById(doc_id);
      if(optionalDto.isPresent()) {
         DocDTO realDto = optionalDto.get();
         
         // 기존 문서 업데이트
         realDto.setDoc_status(dto.getDoc_status());

         return dao.save(realDto);
      }
      
      return dao.findById(doc_id).get();
   }
   
   // 결재완료용 수정페이지
   @Override
   public DocDTO updateEndStatus(int doc_id, DocDTO dto) {
      System.out.println("DocServiceImpl - updateDoc");
      
      // 문서 id를 사용해 해당 문서 찾기
      Optional<DocDTO> optionalDto = dao.findById(doc_id);
      if(optionalDto.isPresent()) {
         DocDTO realDto = optionalDto.get();
         
         // 기존 문서 업데이트
         realDto.setApproval_content(dto.getApproval_content());
         realDto.setApproval_date(dto.getApproval_date());
         realDto.setDoc_status(dto.getDoc_status());

         return dao.save(realDto);
      }
      
      return dao.findById(doc_id).get();
   }
   
   // 결재 반려용 수정페이지
   @Override
   public DocDTO updateBackStatus(int doc_id, DocDTO dto) {
      System.out.println("DocServiceImpl - updateDoc");
      
      // 문서 id를 사용해 해당 문서 찾기
      Optional<DocDTO> optionalDto = dao.findById(doc_id);
      if(optionalDto.isPresent()) {
         DocDTO realDto = optionalDto.get();
         
         // 기존 문서 업데이트
         realDto.setApproval_content(dto.getApproval_content());
         realDto.setApproval_date(dto.getApproval_date());
         realDto.setDoc_status(dto.getDoc_status());

         return dao.save(realDto);
      }
      
      return dao.findById(doc_id).get();
   }

   // 문서삭제페이지
   @Override
   public void deleteDoc(int doc_id) {
      System.out.println("DocServiceImpl - deleteDoc");
      
      dao.deleteById(doc_id);;
   }



}