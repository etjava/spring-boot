package com.etjava.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etjava.bean.User;
import com.etjava.mapper.UserMapper;
import com.etjava.util.CryptographyUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/login")
	public Object login() {
		return "login page";
	}
	
	@RequestMapping("/loginAction")
	public Object loginAction(String userName,String password) {
		
		Subject subject = SecurityUtils.getSubject();
		
		String pass = CryptographyUtil.md5(password, "etjava");
		AuthenticationToken token = new UsernamePasswordToken(userName,pass);
		
		try {
			// 执行无异常则登录成功 如果账号密码错误则抛出异常
			subject.login(token );
			return "success";
		} catch (Exception e) {
			log.error("登录异常 ",e);
			return "error";
		}
	}
	
	// 只有admin角色才可以访问这个方法
	@RequiresRoles("admin")
	@RequestMapping("/findById")
	public Object findById(Integer id) {
		User selectById = userMapper.selectById(id);
		return selectById;
	}
	
	// 只有访问权限为sys:delete才可以访问该方法
	@RequiresPermissions("sys:delete")
	@RequestMapping("/delete")
	public Object delete(Integer id) {
		return userMapper.selectById(id);
	}
	
	
}
