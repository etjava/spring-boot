package com.etjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etjava.entity.User;
import com.etjava.mapper.test1.User1Mapper;
import com.etjava.mapper.test2.User2Mapper;

@RestController
public class UserController {

	
	@Autowired
	private User1Mapper user1Mapper;
	@Autowired
	private User2Mapper user2Mapper;
	
	@RequestMapping("/find1")
	public User find1(Integer id) {
		return user1Mapper.findById(id);
	}
	
	@RequestMapping("/find2")
	public User find2(Integer id) {
		return user2Mapper.findById(id);
	}
}
