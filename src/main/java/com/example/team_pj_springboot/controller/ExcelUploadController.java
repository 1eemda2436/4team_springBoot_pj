package com.example.team_pj_springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.dto.PersonnelMemberDTO;
import com.example.team_pj_springboot.repository.PersonnelMemberRepository;
import com.example.team_pj_springboot.service.ExcelUploadService;
import com.example.team_pj_springboot.service.ExcelUtils;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/admin/excel")
public class ExcelUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelUploadController.class);
	
    @Autowired
    private ExcelUploadService excelUploadService;
    
    @Autowired
    private PersonnelMemberRepository personnelMemberRepository;
    
    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("excelFile") MultipartFile file) {
    	logger.info("[uploadExcelFile]");
        return excelUploadService.uploadExcelData(file);
    }
    
    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) {
        try {
            List<PersonnelMemberDTO> dataList = personnelMemberRepository.findAll();

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=personnel_members.xlsx");

            // 데이터를 엑셀 파일로 변환하여 응답에 쓰기
            ExcelUtils.writeExcelToResponse(dataList, response.getOutputStream());
        } catch (Exception e) {
            // 오류 처리
            e.printStackTrace();
        }
    }
}