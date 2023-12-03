package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	//Before : 대상 "메서드"가 실행되기 전에 Advice 실행
	@Before("execution(* com.example.demo.controller.*.*(..))")
	public void logBefore(JoinPoint jp) {
		LOGGER.info("[ :::  Before aop : "+jp.getSignature().getName()+" ::: ]");
	}
	
	//After : 대상 "메서드"가 실행된 후에 Advice 실행
	@After("execution(* com.example.demo.controller.*.*(..))")
	public void logAfter(JoinPoint jp) {
		LOGGER.info("[ :::  After aop : "+jp.getSignature().getName()+" ::: ]");
	}
	
	//AfterReturning : 대상 "메서드"가 정상적으로 실행되고 반환된 후에 Advice 실행
	@AfterReturning(pointcut = "execution(* com.example.demo.controller.*.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint jp, Object result) {
		LOGGER.info("[ :::  AfterReturning aop : "+jp.getSignature().getName()+", result :"+result+" ::: ]");
	}
	
	//AfterThrowing : 대상 "메서드에서 예외가 발생" 했을 때 Advice 실행
	@AfterThrowing(pointcut = "execution(* com.example.demo.controller.*.*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint jp, Throwable e) {
		LOGGER.info("[ :::  AfterThrowing aop : "+jp.getSignature().getName()+", exception :"+e.getMessage()+" ::: ]");
	}
	
	//Around : 대상 "메서드" 실행 전, 후 또는 예외 발생 시에 Advice 실행
	@Around("execution(* com.example.demo.controller.*.*(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		LOGGER.info("[ :::  Around before aop : "+pjp.getSignature().getName()+" ::: ]");
		Object result = pjp.proceed();
		LOGGER.info("[ :::  Around after aop : "+pjp.getSignature().getName()+" ::: ]");
		return result;
	}
}
