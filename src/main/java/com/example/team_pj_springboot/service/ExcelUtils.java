package com.example.team_pj_springboot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
            double numericValue = row.getCell(18).getNumericCellValue();
            char charValue = (char) (int) numericValue; // 숫자를 char로 변환
            dto.setState(charValue);
            double numericValue2 = row.getCell(19).getNumericCellValue();
            char charValue2 = (char) (int) numericValue2; // 숫자를 char로 변환
            dto.setE_state(charValue2);
            dto.setKey(row.getCell(20).getStringCellValue());
            dto.setAuthority(row.getCell(21).getStringCellValue());
            dto.setEnabled(row.getCell(22).getStringCellValue().charAt(0));

            dataList.add(dto);
        }
        return dataList;
    }
    
    public static void writeExcelToResponse(List<PersonnelMemberDTO> dataList, ServletOutputStream outputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Personnel Members");

        // 엑셀 파일에 헤더 추가
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("회사ID");
        header.createCell(2).setCellValue("비밀번호");
        header.createCell(3).setCellValue("사원 이름");
        header.createCell(4).setCellValue("사원 이메일");
        header.createCell(5).setCellValue("전화번호");
        header.createCell(6).setCellValue("프로필 사진");
        header.createCell(7).setCellValue("입사일");
        header.createCell(8).setCellValue("퇴사일");
        header.createCell(9).setCellValue("생일");
        header.createCell(10).setCellValue("주민번호");
        header.createCell(11).setCellValue("부서 ID");
        header.createCell(12).setCellValue("팀 ID");
        header.createCell(13).setCellValue("직급");
        header.createCell(14).setCellValue("연봉");
        header.createCell(15).setCellValue("계좌");
        header.createCell(16).setCellValue("계약 형태");
        header.createCell(17).setCellValue("사원 사인 이미지");
        header.createCell(18).setCellValue("사원 업무 상태");
        header.createCell(19).setCellValue("재직 여부");
        header.createCell(20).setCellValue("문자 인증");
        header.createCell(21).setCellValue("권한");
        header.createCell(22).setCellValue("인증여부");

        CreationHelper creationHelper = workbook.getCreationHelper(); // CreationHelper 생성
        // 데이터 목록을 엑셀로 작성
        int rowIndex = 1;
        for (PersonnelMemberDTO dto : dataList) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(dto.getId());
            row.createCell(1).setCellValue(dto.getCompany_id());
            row.createCell(2).setCellValue(dto.getPwd());
            row.createCell(3).setCellValue(dto.getName());
            row.createCell(4).setCellValue(dto.getEmail());
            row.createCell(5).setCellValue(dto.getTel());
            row.createCell(6).setCellValue(dto.getProfile());
            // 엑셀 날짜 형식으로 저장
            Cell hiredayCell = row.createCell(7);
            hiredayCell.setCellValue(dto.getHireday()); // 날짜를 그대로 저장
            hiredayCell.setCellStyle(createDateCellStyle(workbook, creationHelper)); //createDateCellStyle메서드 호출

            Cell resignationCell = row.createCell(8);
            resignationCell.setCellValue(dto.getResignation());
            resignationCell.setCellStyle(createDateCellStyle(workbook, creationHelper));

            Cell birthdayCell = row.createCell(9);
            birthdayCell.setCellValue(dto.getBirthday());
            birthdayCell.setCellStyle(createDateCellStyle(workbook, creationHelper));
            row.createCell(10).setCellValue(dto.getResident());
            row.createCell(11).setCellValue(dto.getDepart_id());
            row.createCell(12).setCellValue(dto.getTeam_id());
            row.createCell(13).setCellValue(dto.getRank());
            row.createCell(14).setCellValue(dto.getSalary());
            row.createCell(15).setCellValue(dto.getBank());
            row.createCell(16).setCellValue(dto.getContract());
            row.createCell(17).setCellValue(dto.getSign());
            row.createCell(18).setCellValue(dto.getState());
            row.createCell(19).setCellValue(dto.getE_state());
            row.createCell(20).setCellValue(dto.getKey());
            row.createCell(21).setCellValue(dto.getAuthority());
            row.createCell(22).setCellValue(dto.getEnabled());
        }

        workbook.write(outputStream);
    }
    
    private static CellStyle createDateCellStyle(Workbook workbook, CreationHelper creationHelper) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd")); // 날짜 형식 지정
        return cellStyle;
    }
}
