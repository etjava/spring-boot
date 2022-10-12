package com.etjava.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@TableName("t_premission")
@Data
public class Premission {
	
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String preName;
	private Integer roleId;
}
