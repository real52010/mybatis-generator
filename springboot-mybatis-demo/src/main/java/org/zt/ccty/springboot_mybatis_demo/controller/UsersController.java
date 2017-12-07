package org.zt.ccty.springboot_mybatis_demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zt.ccty.springboot_mybatis_demo.model.User;
import org.zt.ccty.springboot_mybatis_demo.service.UserService;
import org.zt.ccty.springboot_mybatis_demo.service.UserServiceImpl;
import com.alibaba.fastjson.JSON;



@Controller
@RequestMapping("/users")
public class UsersController {



    private Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
    	List<User> users = userService.getUserInfo();
        if(users!=null){
            System.out.println(JSON.toJSON(users));
            logger.info("user.getAge():"+JSON.toJSON(users));
        }
        return users;
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public User getUserInfoById(HttpServletRequest request,String id) {
    	User user= new User();
    	user.setName("a"+id);
    	user.setPhone("123");
    	user.setAge(10);
    	user.setSex("f");
    	userService.insert(user);
//		List<User> list =userService.getUserInfo();
//		logger.info("====11=="+list.size());
    	return user;
       
    }

}
