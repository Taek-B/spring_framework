package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;

public class MainClass {
	public static void main(String[] args) {
		// beans.xml 파일을 로딩한다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		
		// xml에 정의한 bean 객체의 주소값을 가져온다.
		// bean객체 사용
		// 방법1 : 오브젝트를 HelloWorld 
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		callMethod(hello1);
		
		// 방법2 : 타입을 처음부터 HelloWorld로 가져옴
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(hello2);
		
		ctx.close();
	}
	
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
