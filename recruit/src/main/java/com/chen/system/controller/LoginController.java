package com.chen.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户登入登出验证
 * @author chencundeng
 * @version 1.0v 2018年3月20日
 */
@RequestMapping("/system/login")
@Controller
public class LoginController extends BaseController{
    
	@RequestMapping("/loginip")
	public String loginip() {
		return "/system/login/login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "/system/login/login_main";
	}
	
	
}
