package org.zt.ccty.springboot_mybatis_demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "test success!";
	}
}
