package com.etjava.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.etjava.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

