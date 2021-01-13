package com.markany.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// advice + joinpoint + pointcut 을 합친 class

@Aspect
@Component
public class MyAspect {	
	
	@Before("execution(public com.markany.aoptest.vo.ProductVo com.markany.aoptest.service.ProductService.find(String))") // ()안에 point cut 지정(패키지.class.함수)
	public void beforeAdvice() {
		System.out.println("--- Before Advice ---");
	}
	
	// 경로 간단히하기
	// 1. public 생략가능
	// 2. return 타입을 모든 타입으로 지정
	// 3. service 패키지 아래에 productservice에 모든 메소드!(parameter타입은 생략)
	@After("execution(* *..*.service.ProductService.*(..))") // ()안에 point cut 지정(패키지.class.함수)
	public void afterAdvice() {
		System.out.println("--- After Advice ---");
	}
	
	// return이 되기 전!
	@AfterReturning("execution(* *..*.service.ProductService.*(..))") 
	public void afterReturningAdvice() {
		System.out.println("--- AfterReturning Advice ---");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.ProductService.*(..))", throwing ="ex") // 모든 예외를 받아줌 
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("--- AfterThrowing Advice : "+ ex +"---");
	}

	@Around("execution(* *..*.*.ProductService.*(..))") 
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// ProceedJoinPoint : 해당 method가 실행하는 시점을 알려준다..?
		// before advice
		System.out.println("--- @Around(Before) Advice ---");
		
		// PointCut Method 실행
		Object result = pjp.proceed();
		
//		// parameter 가로채기(바꿔버리기)
//		Object[] params = {"camera"};
//		Object result = pjp.proceed(params);
		
		// after advice
		System.out.println("--- @Around(After) Advice ---");
		
		return result;
	}
}
