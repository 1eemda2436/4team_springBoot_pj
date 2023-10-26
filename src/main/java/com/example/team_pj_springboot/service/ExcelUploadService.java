package com.example.team_pj_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.dto.PersonnelMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;
import com.example.team_pj_springboot.repository.PersonnelMemberRepository;
import com.example.team_pj_springboot.repository.SalaryRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

@Service
public class ExcelUploadService {

	@Autowired
	private PersonnelMemberRepository personnelMemberRepository;

	@Autowired
	private SalaryRepository salaryRepository;

	//    public String uploadExcelData(MultipartFile file) {
	//        try {
	//            List<PersonnelMemberDTO> dataList = ExcelUtils.readExcelFile(file);
	//
	//            // 중복 ID 확인 및 처리
	//            List<String> duplicateIds = findDuplicateIds(dataList);
	//            if (!duplicateIds.isEmpty()) {
	//                // 중복 ID가 있는 경우 처리
	//                return "중복된 ID가 있습니다: " + String.join(", ", duplicateIds);
	//            }
	//
	//            // 데이터베이스에 저장
	//            personnelMemberRepository.saveAll(dataList);
	//
	//            return "엑셀 파일 업로드 및 저장 성공!";
	//        } catch (Exception e) {
	//            return "엑셀 파일 업로드 및 저장 실패: " + e.getMessage();
	//        }
	//    }
	//    
	//    //파일 업로드시 ID 중복 체크
	//    private List<String> findDuplicateIds(List<PersonnelMemberDTO> dataList) {
	//        List<String> duplicateIds = new ArrayList<>();
	//        Set<String> uniqueIds = new HashSet<>();
	//
	//        for (PersonnelMemberDTO dto : dataList) {
	//            String id = dto.getId();
	//            if (uniqueIds.contains(id)) {
	//                duplicateIds.add(id);
	//            } else {
	//                uniqueIds.add(id);
	//            }
	//        }
	//
	//        return duplicateIds;
	//    }

	public String uploadExcelData(MultipartFile file) {
		try {
			List<PersonnelMemberDTO> dataList = ExcelUtils.readExcelFile(file);

			// 중복 ID 확인 및 처리
			List<String> duplicateIds = findDuplicateIds(dataList);
			if (!duplicateIds.isEmpty()) {
				// 중복 ID가 있는 경우 처리
				return "중복된 ID가 있습니다: " + String.join(", ", duplicateIds);
			}

			// 데이터베이스에 Personnel Member 정보 저장
			personnelMemberRepository.saveAll(dataList);

			for (PersonnelMemberDTO dto : dataList) {
				// Salary 정보를 저장
				saveSalary(dto);
			}

			return "엑셀 파일 업로드 및 저장 성공!";
		} catch (Exception e) {
			return "엑셀 파일 업로드 및 저장 실패: " + e.getMessage();
		}
	}

	// 파일 업로드시 ID 중복 체크
	private List<String> findDuplicateIds(List<PersonnelMemberDTO> dataList) {
		List<String> duplicateIds = new ArrayList<>();
		Set<String> uniqueIds = new HashSet<>();

		for (PersonnelMemberDTO dto : dataList) {
			String id = dto.getId();
			if (uniqueIds.contains(id)) {
				duplicateIds.add(id);
			} else {
				uniqueIds.add(id);
			}
		}
		return duplicateIds;
	}

	//회원 추가시 월급상세 추가를 위한 메서드
	@Transactional
	public SalaryDTO saveSalary(PersonnelMemberDTO dto) {
		SalaryDTO sadto = new SalaryDTO();
		sadto.setId(dto.getId());

		SalaryDTO saveSalary = salaryRepository.save(sadto);

		return saveSalary;
	}

}
