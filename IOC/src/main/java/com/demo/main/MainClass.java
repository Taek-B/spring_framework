package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;

public class MainClass {
	public static void main(String[] args) {
		// beans.xml 파일을 로딩한다.(필요한 객체들을 자동생성)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		
		TestBean t1 = ctx.getBean("t1",TestBean.class);
		System.out.printf("t1 : %s\n", t1);

		TestBean t2 = ctx.getBean("t1",TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		
		ctx.close();
	}
	
}
