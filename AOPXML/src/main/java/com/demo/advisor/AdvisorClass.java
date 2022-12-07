package com.demo.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
	
	public void beforeMethod() {
		System.out.println("beforeMethod 호출");
	}
	
	public void afterMethod() {
		System.out.println("afterMethod 호출");
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("aroundMethod 호출1");
		
		// 원래의 메서드를 호출한다.
		Object obj = pjp.proceed();
		
		System.out.println("aroundMethod 호출 2");
		
		return obj;
	}
}


