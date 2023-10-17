package com.example.team_pj_springboot.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_pj_springboot.dto.MemberDTO;
import com.example.team_pj_springboot.dto.SalaryAndMemberDTO;
import com.example.team_pj_springboot.dto.SalaryDTO;
import com.example.team_pj_springboot.dto.payStatementDTO;
import com.example.team_pj_springboot.service.SalaryService;

//http://localhost:8081/salary

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 URL로 대체
@RestController
@RequestMapping("/salary") 
public class SalaryController {
	private static final Logger logger = LoggerFactory.getLogger(SalaryController.class);
	
	@Autowired
	private SalaryService service;

	//급여관리 메인 페이지
	@GetMapping("/salaryMain")
    public List<SalaryAndMemberDTO> salaryAndMemberInfo() {
		logger.info("[salaryAndMemberInfo]");
		
        return service.getSalaryAndMemberInfo();
    }
	
	//급여 관리 명세서
	@GetMapping("/PayStatement/{id}")
	public Optional<payStatementDTO> payStatement(@PathVariable String id) {
		logger.info("[payStatement]");

		Optional<payStatementDTO> dto = service.payStatementInfo(id);
		
		return dto;
	}
	
	//급여 계산
	@PutMapping("/calculateTaxes")
    public ResponseEntity<SalaryDTO> addSalary(@RequestBody SalaryDTO dto) {
        System.out.println("!!!" + dto);
	    // 여기에서 복잡한 세금 및 보험료 계산을 수행하고 결과를 저장
	    int incomeTax = calculateIncomeTax(dto.getSalary()); //소득세
	    int localTax = (int) (incomeTax * 0.1); // 지방소득세 10%
	    int nationalPension = (int) (dto.getSalary() * 0.09 * 0.045); // 국민연금
	    int healthInsurance = (int) (dto.getSalary() * 0.0686); // 건강보험
	    int CHealthInsurance = (int) (healthInsurance * 0.1227); //장기요양건강보험
	    int employmentInsurance = (int) (dto.getSalary() * 0.009);//고용보험
	    
	    // SalaryDTO 엔터티를 만들어서 데이터베이스에 저장
	    SalaryDTO salaryDTO = new SalaryDTO();
	    salaryDTO.setId(dto.getId());
	    salaryDTO.setSalary(dto.getSalary());				//기본급
	    salaryDTO.setIncome_tax(incomeTax);					//소득세
	    salaryDTO.setLocal_tax(localTax);					//지방소득세
	    salaryDTO.setNational_pension(nationalPension);		//국민연금
	    salaryDTO.setHealth_insurance(healthInsurance);		//건강보험
	    salaryDTO.setC_health_insurance(CHealthInsurance);	//장기요양건강보험
	    salaryDTO.setEmployment_insurance(employmentInsurance);//고용보험
	    
	    salaryDTO.setBonus(dto.getBonus());					//상여금
	    salaryDTO.setOvertime_pay(dto.getOvertime_pay());	//야근수당
	    salaryDTO.setAllowance(dto.getAllowance());			//연차수당
	    salaryDTO.setFood_pay(dto.getFood_pay());			//식비
	    salaryDTO.setT_pay(dto.getT_pay());					//교통비
	    
	    SalaryDTO resultDTO = service.saveSalary(salaryDTO);
	    return ResponseEntity.ok(resultDTO);
    }
    
    //소득세 계산
    public int calculateIncomeTax(int salary) {
        int incomeTax;
        if (salary <= 14000000) {
            incomeTax = (int) (salary * 0.06);
        } else if (salary <= 50000000) {
            incomeTax = 840000 + (int) ((salary - 14000000) * 0.15);
        } else if (salary <= 88000000) {
            incomeTax = 6240000 + (int) ((salary - 50000000) * 0.24);
        } else if (salary <= 150000000) {
            incomeTax = 15360000 + (int) ((salary - 88000000) * 0.35);
        } else if (salary <= 300000000) {
            incomeTax = 37060000 + (int) ((salary - 150000000) * 0.38);
        } else if (salary <= 500000000) {
            incomeTax = 94060000 + (int) ((salary - 300000000) * 0.40);
        } else if (salary <= 1000000000) {
            incomeTax = 174060000 + (int) ((salary - 500000000) * 0.42);
        } else {
            incomeTax = 384060000 + (int) ((salary - 1000000000) * 0.45);
        }
        return incomeTax;
    }


	//인사관리 메인 페이지
	@GetMapping("/personnel")
	public List<MemberDTO> personnelInfo(){
		logger.info("[personnelInfo]");
		
		return service.getPersonnelInfo();
	}
	
	
}
