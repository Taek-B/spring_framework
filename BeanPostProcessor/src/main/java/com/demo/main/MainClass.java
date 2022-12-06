package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean1;

public class MainClass {
	public static void main(String[] args) {
		// beans.xml 파일을 로딩한다.(필요한 객체들을 자동생성)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		
		// t1 객체를 가져옴(lazy-init, init-method)
		TestBean1 t1 = ctx.getBean("t1",TestBean1.class);
		System.out.printf("t1 : %s\n", t1);
		
		ctx.close();
	}
	
}
