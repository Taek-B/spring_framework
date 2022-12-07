package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.beans.JdbcBean;

public interface MapperInterface {
	// crud 및 커스텀 sql문을 여기에 설정

	/*
	 * 만약 빈의 변수명(property)과 테이블 컬럼의 이름이 다르다면 여기에 설정한다.
	 * 
	 * @Results({
	 * 
	 * @Result(column = "int_data", property = "int_data"),
	 * 
	 * @Result(column = "str_data", property = "str_data") })
	 */
	
	@Select("select INT_DATA, STR_DATA from JDBC")
	List<JdbcBean> select_data();
	
	@Insert("insert into JDBC (INT_DATA, STR_DATA) values (#{int_data}, #{str_data})")
	void insert_data(JdbcBean bean);
	
	@Update("update JDBC set STR_DATA = #{str_data} where INT_DATA = #{int_data}")
	void update_data(JdbcBean bean);
	
	@Delete("delete from JDBC where INT_DATA = #{abc}")
	void delete_data(int int_data);
	
}