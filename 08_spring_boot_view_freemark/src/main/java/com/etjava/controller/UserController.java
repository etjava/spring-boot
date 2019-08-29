package com.etjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etjava.entity.Users;

/**
 * 	整合 freemarker
 * @author asus
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/info")
	public String showUser(Model model){
		List<Users> list = new ArrayList<>(3);
		list.add(new Users(1,"Tom",22));
		list.add(new Users(2,"Jerry",24));
		list.add(new Users(1,"Andy",28));
		
		model.addAttribute("list222",list);
		return "userList"; // 对应userList.ftl
		
	}
}
