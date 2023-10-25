package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.team_pj_springboot.dto.PersonnelMemberDTO;

public class ExcelUtils {

    public static List<PersonnelMemberDTO> readExcelFile(MultipartFile file) throws IOException, InvalidFormatException {
        List<PersonnelMemberDTO> dataList = new ArrayList<>();

        // 엑셀 파일을 읽기 위한 워크북 생성
        Workbook workbook = WorkbookFactory.create(file.getInputStream());

        // 엑셀 파일의 첫 번째 시트를 선택
        Sheet sheet = workbook.getSheetAt(0);
        

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // 헤더 행을 건너뜁니다.
            }

            PersonnelMemberDTO dto = new PersonnelMemberDTO();

            // 엑셀 파일의 각 열에서 데이터를 읽어 DTO 객체에 설정
            DataFormatter dataFormatter = new DataFormatter();
            dto.setId(dataFormatter.formatCellValue(row.getCell(0)));
            dto.setCompany_id(dataFormatter.formatCellValue(row.getCell(1)));
            dto.setPwd(dataFormatter.formatCellValue(row.getCell(2)));
            dto.setName(row.getCell(3).getStringCellValue());
            dto.setEmail(row.getCell(4).getStringCellValue());
            dto.setTel(dataFormatter.formatCellValue(row.getCell(5)));
            dto.setProfile(row.getCell(6).getStringCellValue());
            dto.setHireday(row.getCell(7).getDateCellValue());
            dto.setResignation(row.getCell(8).getDateCellValue());
            dto.setBirthday(row.getCell(9).getDateCellValue());
            dto.setResident((int) row.getCell(10).getNumericCellValue());
            dto.setDepart_id((int) row.getCell(11).getNumericCellValue());
            dto.setTeam_id((int) row.getCell(12).getNumericCellValue());
            dto.setSalary((int) row.getCell(14).getNumericCellValue());
            dto.setBank(row.getCell(15).getStringCellValue());
            dto.setContract(row.getCell(16).getStringCellValue());
            dto.setSign(row.getCell(17).getStringCellValue());
            //dto.setState(row.getCell(18).getStringCellValue().charAt(0));
            double numericValue = row.getCell(18).getNumericCellValue();
            char charValue = (char) (int) numericValue; // 숫자를 char로 변환
            dto.setState(charValue);
            //dto.setE_state(row.getCell(19).getStringCellValue().charAt(0));
            double numericValue2 = row.getCell(19).getNumericCellValue();
            char charValue2 = (char) (int) numericValue; // 숫자를 char로 변환
            dto.setE_state(charValue2);
            dto.setKey(row.getCell(20).getStringCellValue());
            dto.setAuthority(row.getCell(21).getStringCellValue());
            dto.setEnabled(row.getCell(22).getStringCellValue().charAt(0));

//         // 문자열로 읽어오기
//        dto.setId(row.getCell(0).getStringCellValue());
//        dto.setCompany_id(row.getCell(1).getStringCellValue());
//        dto.setPwd(row.getCell(2).getStringCellValue());
//        dto.setTel(row.getCell(5).getStringCellValue());
//
//        // 날짜로 읽어오기
//        dto.setHireday(row.getCell(7).getDateCellValue());
//        dto.setResignation(row.getCell(8).getDateCellValue());
//        dto.setBirthday(row.getCell(9).getDateCellValue());
//
//        // 숫자로 읽어오기
//        dto.setResident((int) row.getCell(10).getNumericCellValue());
//        dto.setDepart_id((int) row.getCell(11).getNumericCellValue());
//        dto.setTeam_id((int) row.getCell(12).getNumericCellValue());
//        dto.setSalary((int) row.getCell(14).getNumericCellValue());
//
//        // 문자 또는 문자(char)로 읽어오기
//        dto.setState(row.getCell(18).getStringCellValue().charAt(0));
//        dto.setE_state(row.getCell(19).getStringCellValue().charAt(0));
//        dto.setEnabled(row.getCell(22).getStringCellValue().charAt(0));
            
            dataList.add(dto);
        }

        return dataList;
    }
}
