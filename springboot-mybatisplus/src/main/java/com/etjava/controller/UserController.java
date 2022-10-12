package com.etjava.controller;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.etjava.mapper.UserMapper;
import com.etjava.entity.User;

@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/find")
	public Object fidOne(Integer id) {
		
		return userMapper.selectById(id);
	}
	
	@RequestMapping("/save")
	public Object save(User user) {
		return userMapper.insert(user);
	}
	
	/**
	 * 分页查询
	 * @param pagenum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list")
	public Object list(Integer pagenum,Integer pageSize) {
		Wrapper<User> warpper = new EntityWrapper<>();
		RowBounds bonds = new RowBounds((pagenum-1)*pageSize,pageSize);
		return userMapper.selectPage(bonds, warpper);
	}
	
	/**
	 * 条件查询
	 * @param q
	 * @return
	 */
	@RequestMapping("/q")
	public Object q(String q) {
		Wrapper<User> wrapper = new EntityWrapper<>();
		wrapper.eq("name", q);
		wrapper.between("id", 0, 100);                                        
		wrapper.groupBy("name");                                       
		wrapper.isNotNull("name");                                     
		wrapper.orderBy("id", false);      
		return userMapper.selectList(wrapper);
	}
}
