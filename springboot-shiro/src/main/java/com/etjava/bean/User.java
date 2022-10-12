package com.etjava.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@Data
@TableName("t_user")
public class User {

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private String password;
	private Integer roleId;
}
