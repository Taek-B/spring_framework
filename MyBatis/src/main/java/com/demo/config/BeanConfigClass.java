package com.demo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.mapper.MapperInterface;

@Configuration
@ComponentScan(basePackages = { "com.demo.beans" })
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

	// JdbcTemplate 대신 MyBatis

	// SqlSessionFactory : jdbc를 처리하는 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}

	// Mapper 인터페이스 구현 객체 (dao)
	// Mapper 인터페이스에 sql문을 적으면 그 mapper로 실제 구현한 객체를 생성한다.
	@Bean
	public MapperFactoryBean<MapperInterface> test_mapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

}
