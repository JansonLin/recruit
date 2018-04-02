package com.chen.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.system.service.SysUserService;

/**
 * 系统用户控制类
 * @author chencundeng
 * @version 1.0v 2018年3月14日
 */
@Controller
@RequestMapping("/system/sysUser")
public class SysUserController {
    
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/main")
	@ResponseBody
	public String main() {
		System.out.println("=============="+sysUserService.find(1L));
		return "hello";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, String> test(){
		Map<String, String> map = new HashMap<>();
		map.put("name", "dengfuyu");
		return map;
	}
	
}
