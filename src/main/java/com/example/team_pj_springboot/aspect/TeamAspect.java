package com.example.team_pj_springboot.aspect;

import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class TeamAspect {
    
	@AfterReturning(pointcut = "execution(* com.example.team_pj_springboot.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
		log.info("AfterReturning: " + joinPoint.getSignature().getName() + "/ result: " + result);
    }
	
	@AfterThrowing(pointcut = "execution(* com.example.team_pj_springboot.service.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e	) {
		log.info("AfterThrowing: " + joinPoint.getSignature().getName() + " exception: " + e.getMessage());
	}
	
	@Around("execution(* com.example.team_pj_springboot.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis(); // 메서드 시작 시간 기록
        log.info("Around before: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis(); // 메서드 종료 시간 기록
        long executionTime = endTime - startTime; // 메서드 실행 시간 계산

        log.info("Around after: " + joinPoint.getSignature().getName());
        log.info("time of" + joinPoint.getSignature().getName() + ": " + executionTime + " ms");

        return result;
    }
}
