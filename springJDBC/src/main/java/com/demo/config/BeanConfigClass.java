package com.demo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "com.demo.beans", "com.demo.db" })
public class BeanConfigClass {
	// DataSource 등록
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		// 오라클 사용시
//		source.setDriverClassName("oracle.jdbc.OracleDriver");
//		source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		source.setUsername("scott");
//		source.setPassword("1234");

		// MySQL 사용시
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/JDBC_test");
		source.setUsername("root");
		source.setPassword("1234");

		return source;
	}

	// 데이터베이스에 접속해서 쿼리를 전달하는 빈을 등록한다.
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
	}

}
