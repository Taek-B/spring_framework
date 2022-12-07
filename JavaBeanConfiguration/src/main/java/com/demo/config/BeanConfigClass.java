package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import com.demo.beans.TestBean4;

@Configuration
public class BeanConfigClass {
	
	@Bean
	public TestBean1 java1() {
//		TestBean1 t1 = new TestBean1();
//		return t1;
		
		return new TestBean1(); // 위에 주석된 코드랑 같음
	}
	
	@Bean(name = "java600")
	public TestBean1 java500() {
		TestBean1 t1 = new TestBean1();
		return t1;
	}
	
	@Bean
	@Lazy
	public TestBean2 java2() {
		TestBean2 t2 = new TestBean2();
		return t2;
	}
	
	@Bean
	@Scope("prototype")
	public TestBean3 java3() {
		TestBean3 t3 = new TestBean3();
		return t3;
	}
	
	@Bean
	public TestBean4 java4() {
		TestBean4 t4 = new TestBean4();
		return t4;
	}
	
	@Bean
	@Primary
	public TestBean4 java5() {
		TestBean4 t4 = new TestBean4();
		return t4;
	}


}
