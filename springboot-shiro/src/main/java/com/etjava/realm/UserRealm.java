package com.etjava.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.etjava.bean.Premission;
import com.etjava.bean.Role;
import com.etjava.bean.User;
import com.etjava.mapper.PremissionMapper;
import com.etjava.mapper.RoleMapper;
import com.etjava.mapper.UserMapper;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PremissionMapper premissionMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		// 获取登录的用户名
		String username = (String)pc.getPrimaryPrincipal();
		// 获取到当前用户的角色和权限
		User u = userMapper.selectOne2(username);
		Integer roleId = u.getRoleId();
		Role role = roleMapper.selectById(roleId);
		// 授权角色
		info.addRole(role.getRoleName());
		// 获取当前用户的权限并进行授权
		Wrapper<Premission> wrapper = new EntityWrapper<Premission>();
		wrapper.eq("roleId", role.getId());
		List<Premission> preList = premissionMapper.selectList(wrapper );
		// 需要将权限转成String类型的数组
		List<String> list = new ArrayList<>();
		preList.forEach(p -> {
			list.add(p.getPreName());
		});
		info.addStringPermissions(list);
		
		
		return info;
	}
	// 这里做登录控制
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		User u = userMapper.selectOne2(username);
		if(u!=null) {
			AuthenticationInfo auth = new SimpleAuthenticationInfo(u.getName(),u.getPassword(),"others wirte");
			return auth;
		}
		return null;
	}
}
