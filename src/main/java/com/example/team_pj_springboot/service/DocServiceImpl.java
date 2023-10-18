package com.example.team_pj_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team_pj_springboot.repository.ApprovalRepository;
import com.example.team_pj_springboot.repository.DocRepository;
import com.example.team_pj_springboot.repository.MemberRepository;
import com.example.team_pj_springboot.repository.TemporaryRepository;
import com.example.team_pj_springboot.repository.ViewRepository;
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
import com.example.team_pj_springboot.dto.ViewAndDocDTO;
import com.example.team_pj_springboot.dto.ViewDTO;

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
	public List<ViewDTO> viewList() {
		System.out.println("DocServiceImpl - viewList");
		List<ViewDTO> list= viewDao.findAll();
//		return viewDao.viewList();
		System.out.println("!!!" + list);
		return list;
	}

	// 임시저장목록
	@Override
	public List<DocAndTemporaryDTO> temporaryList() {
		System.out.println("DocServiceImpl - temporaryList");
		
		return temporaryDao.temporaryList();
	}

	// 결재완료문서함
	@Override
	public List<ApprovalEndAndDocDTO> approvalEndList() {
		System.out.println("DocServiceImpl - approvalEndList");
		
		return approvalDao.ApprovalEndList();
	}

	// 결재예정문서함
	@Override
	public List<ApprovalIngAndDocDTO> approvalIngList() {
		System.out.println("DocServiceImpl - approvalIngList");
		
		return approvalDao.approvalIngList();
	}

	// 결재반려문서함
	@Override
	public List<ApprovalBackAndDocDTO> approvalBackList() {
		System.out.println("DocServiceImpl - approvalBackList");
		
		return approvalDao.approvalBackList();
	}

	// 문서작성페이지
	@Override
	public DocDTO insertDoc(DocDTO dto) {
		System.out.println("DocServiceImpl - insertDoc");
		
		return dao.save(dto);
	}
	
	// 문서상세페이지
	@Override
	public Optional<DocAndCategoryDTO> selectDoc(int doc_id) {
		System.out.println("DocServiceImpl - selectDoc");
		
		return dao.selectOneDoc(doc_id);
	}
	
	// 결재문서상세페이지
	@Override
	public Optional<ApprovalAndDocDTO> selectApp(int approval_id) {
		System.out.println("DocServiceImpl - selectApp");
		
		return approvalDao.selectApp(approval_id);
	}

	// 문서수정페이지
	@Override
	public DocDTO updateDoc(int doc_id) {
		System.out.println("DocServiceImpl - updateDoc");
		
		
		return dao.findById(doc_id).get();
	}

	// 문서삭제페이지
	@Override
	public void deleteDoc(int doc_id) {
		System.out.println("DocServiceImpl - deleteDoc");
		
		dao.deleteById(doc_id);;
	}

}
