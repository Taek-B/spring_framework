package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		// beans.xml 파일을 로딩한다.(필요한 객체들을 자동생성)
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
//
//		ctx.close();
		
		// @Configuration를 가진 Java파일을 가져온다.
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 java1 = ctx.getBean("java1", TestBean1.class);
		System.out.printf("java1 : %s\n", java1);
		
		System.out.println("-------------------------------");
		
		TestBean1 java600 = ctx.getBean("java600", TestBean1.class);
		System.out.printf("java600 : %s\n", java600);
		


	
		ctx.close();
	}
}
