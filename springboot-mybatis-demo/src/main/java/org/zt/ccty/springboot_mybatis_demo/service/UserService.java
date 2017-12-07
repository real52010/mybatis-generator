package org.zt.ccty.springboot_mybatis_demo.service;

import java.util.List;

import org.zt.ccty.springboot_mybatis_demo.model.User;

public interface UserService {

	public List<User> getUserInfo();
	
	public User getUserInfoById(String id);
	
	public void insert(User user) ;
}
