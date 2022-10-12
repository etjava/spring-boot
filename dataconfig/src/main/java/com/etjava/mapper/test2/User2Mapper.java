package com.etjava.mapper.test2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.etjava.entity.User;

@Mapper
public interface User2Mapper {

	@Select("select * from t_user where id=#{id}")
	User findById(@Param("id") Integer id);
}
