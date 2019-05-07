package com.real.demo.biz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.real.demo.common.Constant;
import com.real.demo.common.base.BaseResponse;

import io.swagger.annotations.Api;

@Api(tags = "用户相关接口")
@RestController()
@RequestMapping(value = "/user", method = RequestMethod.POST, produces = Constant.CONTENT_PRODUCES, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	public BaseResponse register() {
		return null;
	};

	public BaseResponse login() {
		return null;
	};

	public BaseResponse logout() {
		return null;
	};
}
