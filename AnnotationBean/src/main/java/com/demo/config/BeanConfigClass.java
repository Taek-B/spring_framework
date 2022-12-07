package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.beans.DataBean1;
import com.demo.beans.DataBean2;
import com.demo.beans.TestBean1;

@Configuration
public class BeanConfigClass {
	
	// java1 등록
	@Bean
	public TestBean1 java1() {
//		TestBean1 t1 = new TestBean1();
//		return t1;

		return new TestBean1(); // 위에 주석된 코드랑 같음
	}

	// DataBean1 타입 data_bean1 등록
//	 @Bean
	public DataBean1 data_bean1() {
		return new DataBean1();
	}

	// DataBean2 obj4와 ojb5 등록
	@Bean
	public DataBean2 obj4() {
		return new DataBean2();
	}
	
	@Bean
	public DataBean2 obj5() {
		return new DataBean2();
	}

}
