package org.zt.ccty.springboot_mybatis_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zt.ccty.springboot_mybatis_demo.SpringUtils;
import org.zt.ccty.springboot_mybatis_demo.dao.UserDAO;
import org.zt.ccty.springboot_mybatis_demo.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by zl on 2015/8/27.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<User> getUserInfo() {
		List<User> users = userDao.getUserInfo();
		// User user=null;
		return users;
	}

	public User getUserInfoById(String id) {
		User user = userDao.getUserInfoById(id);
		return user;
	}
    @Transactional
	public void insert(User user) {
		userDao.insert(user);
		// 采取这种方式的话，
		// @EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
		// 必须设置为true
		// List<User> list = ((UserService) AopContext.currentProxy()).getUserInfo();
		// System.out.println(
		// "==========" + list.size() +
		// "=================================================================");
		// ;

//		 List<User> list = (UserService)( SpringUtils.getBean(this.getClass()).getUserInfo());
//		UserService service =SpringUtils.getBean(UserService.class);
		List<User> list =this.getUserInfo();
		log.info("========"+list.size());
//		if (true) {
//			throw new RuntizmeException("test transaction");
//		}
	}
}
