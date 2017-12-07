package org.zt.ccty.springboot_mybatis_demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zt.ccty.springboot_mybatis_demo.model.User;

public interface UserDAO {

	public List<User> getUserInfo();

	public User getUserInfoById(@Param("id") String id);

	public int insert(User user);
	
}
