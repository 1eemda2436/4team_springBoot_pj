package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

public interface DocService {
   
   // 통합문서함
   public MemberDTO selectMember(String id);

   // 기안문서함
   public List<DocAndDraftDTO> draftList();
   
   // 회람문서함
   public List<DocDTO> viewList();
   
   // 임시저장목록
   public List<DocAndTemporaryDTO> temporaryList();
   
   // 결재완료문서함
   public List<ApprovalEndAndDocDTO> approvalEndList();
   
   // 결재예정문서함
   public List<ApprovalIngAndDocDTO> approvalIngList();
   
   // 결재반려문서함
   public List<ApprovalBackAndDocDTO> approvalBackList();
   
   // 문서작성페이지
   public DocDTO insertDoc(DocDTO dto) throws IOException;
   
   // 문서상세페이지
   public Optional<DocAndCategoryDTO> selectDoc(int doc_id);
   
   // 결재문서상세페이지
   public Optional<ApprovalAndDocDTO> selectApp(int approval_id);
   
   // 문서수정페이지
   public DocDTO updateDoc(int doc_id);
   
   // 문서삭제페이지
   public void deleteDoc(int doc_id); 
   
   // 파일업로드
   public String uploadFile(MultipartFile doc_attachment) throws IOException;
   
}