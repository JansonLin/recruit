package com.chen.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户登入登出验证
 * @author chencundeng
 * @version 1.0v 2018年3月20日
 */
@RequestMapping("/system/login")
@Controller
public class LoginController {
    
	@RequestMapping("/loginip")
	public String loginip() {
		return "/system/login/login";
	}
	
}
