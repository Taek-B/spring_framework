package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;

public class MainClass {
	public static void main(String[] args) {
		// beans.xml 파일을 로딩한다.(필요한 객체들을 자동생성)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		
		
		// id가 없으므로 클래스의 타입만 가지고 객체를 가져옴
		// 이떄에 문제는 똑같은 타입이 있을 경우 못 가져옴!!!!!
		TestBean t0 = ctx.getBean("test0",TestBean.class);
		System.out.printf("t0 : %s\n", t0);
		
		// id가 있을 때 id로 가져옴
		TestBean t1 = ctx.getBean("test1",TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		// 가져오는 test1의 Bean이 같으므로 bean값도 같다
		TestBean t2 = ctx.getBean("test1",TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		
		// lazy-init은 데이터를 가져올 때 객체를 생성한다.
		TestBean t3 = ctx.getBean("test2",TestBean.class);
		System.out.printf("t3 : %s\n", t3);
		
		// scope=prototype은 가져올때마다 생성 ( 이때 bean 값이 다 다름 )
		TestBean t4 = ctx.getBean("test3",TestBean.class);
		System.out.printf("t4 : %s\n", t4);
		TestBean t5 = ctx.getBean("test3",TestBean.class);
		System.out.printf("t5 : %s\n", t5);
		
		ctx.close();
	}
	
}
