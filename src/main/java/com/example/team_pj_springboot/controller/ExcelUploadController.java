package com.example.team_pj_springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.service.ExcelUploadService;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/admin/excel")
public class ExcelUploadController {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUploadController.class);
	
    @Autowired
    private ExcelUploadService excelUploadService;

    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("excelFile") MultipartFile file) {
        return excelUploadService.uploadExcelData(file);
    }
}