package com.etjava.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.etjava.bean.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{

	
	@Select("select * from t_user where name = #{userName}")
	User selectOne2(@Param("userName") String userName);
	
	
	
	
}
