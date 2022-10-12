package com.etjava.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@TableName("t_role")
@Data
public class Role {
	
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String roleName;
	
}
