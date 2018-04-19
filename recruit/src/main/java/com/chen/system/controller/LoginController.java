package com.chen.system.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.common.util.Md5Util;
import com.chen.system.entity.SysUser;
import com.chen.system.entity.SysUserExample;
import com.chen.system.service.SysUserService;


/**
 * 用户登入登出验证
 * @author chencundeng
 * @version 1.0v 2018年3月20日
 */
@RequestMapping("/system/login")
@Controller
public class LoginController extends BaseController{
    
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/loginip")
	public String loginip() {
		return "/system/login/login";
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpServletRequest request,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(null==username){
			return "/system/login/login";
		}
		SysUserExample example = new SysUserExample();
		example.or().andUserNameEqualTo(username).andPasswordEqualTo(Md5Util.EncoderByMd5(password));
		List<SysUser> users = sysUserService.list(example);
		if(null==users||users.size()<1){
			map.put("message", "账号密码错误！");
			return "/system/login/login";
		}
		Set<Long> limits = sysUserService.userLimits(users.get(0).getId());
		if(null==limits||limits.size()<1){  //没有登陆权限
			map.put("message", "用户没有登陆权限！");
			return "/system/login/login";
		}
		request.getSession().setAttribute("user", users.get(0));
		request.getSession().setAttribute("limits", limits);
		return "/system/login/login_main";
	}
	
	
}
