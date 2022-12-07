package com.demo.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.beans.JdbcBean;

@Component
public class JdbcDAO {

	// JDBC 관리 객체를 주입 받는다.
	@Autowired
	private JdbcTemplate db;

	// Mapper를 주입받는다.
	@Autowired
	private MapperClass mapper;

	// 저장
	public void insert_data(JdbcBean bean) {
		String sql = "insert into JDBC (INT_DATA, STR_DATA) values (?, ?)";
		db.update(sql, bean.getInt_data(), bean.getStr_data());
	}

	// 가져오기
	public List<JdbcBean> select_data() {
		String sql = "select INT_DATA, STR_DATA from JDBC";
		List<JdbcBean> list = db.query(sql, mapper);
		return list;
	}

	// 하나만 가져올 때
	public List<JdbcBean> select_data(int int_data) {
		String sql = "select INT_DATA, STR_DATA from JDBC where int_data = ?";
		List<JdbcBean> one = db.query(sql, mapper, int_data);
		return one;
	}

	// 수정
	public void update_data(JdbcBean bean) {
		String sql = "update JDBC set STR_DATA = ? where INT_DATA = ?";
		db.update(sql, bean.getStr_data(), bean.getInt_data());
	}

	// 삭제
	public void delete_data(int int_data) {
		String sql = "delete from JDBC where INT_DATA = ?";
		db.update(sql, int_data);
	}
}
