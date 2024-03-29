package com.example.team_pj_springboot.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

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
import com.example.team_pj_springboot.dto.TemporaryDTO;

public interface DocService {
   
   // 통합문서함
   public MemberDTO selectMember(String id);

   // 기안문서함
   public List<DocAndDraftDTO> draftList();
   
   // 회람문서함
   public List<DocDTO> viewList();
   
   // 임시저장목록
   public List<DocAndDraftDTO> temporaryList();
   
   // 결재통합문서함
   public List<ApprovalIngAndDocDTO> approvalAllList();
   
   // 결재완료문서함
   public List<ApprovalEndAndDocDTO> approvalEndList();
   
   // 결재예정문서함
   public List<ApprovalIngAndDocDTO> approvalIngList();
   
   // 결재요청목록
   public List<ApprovalIngAndDoc2DTO> approvalSelect();
   
   // 결재반려문서함
   public List<ApprovalBackAndDocDTO> approvalBackList();
   
   // 문서작성페이지
   public DocDTO insertDoc(DocDTO dto) throws IOException;
   
   // 문서상세페이지
   public Optional<DocAndCategoryDTO> selectDoc(int doc_id);
   
   // 결재문서상세페이지
   public Optional<DocDTO> selectApp(int approval_id);
   
   // 문서수정페이지
   public DocDTO updateDoc(int doc_id, DocDTO dto);
   
   // 결재요청용 수정페이지
   public DocDTO updateIngStatus(int doc_id, DocDTO dto);
   
   // 결재완료용 수정페이지
   public DocDTO updateEndStatus(int doc_id, DocDTO dto);
   
   // 결재반려용 수정페이지
   public DocDTO updateBackStatus(int doc_id, DocDTO dto);
   
   // 문서삭제페이지
   public void deleteDoc(int doc_id); 
   
   // 파일업로드
   public String uploadFile(MultipartFile doc_attachment) throws IOException;

   // 이미지 가져오기
   public String uploadImageFile(MultipartFile doc_attachment) throws IOException;
   
   // 문서 통계
   public DocProgressBarDTO docChart(String company_id, HttpServletRequest req, Model model) throws ServletException, IOException;
   
}