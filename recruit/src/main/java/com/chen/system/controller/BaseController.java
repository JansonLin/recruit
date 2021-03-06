package com.chen.system.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.chen.system.entity.SysUser;

public class BaseController {
  
	/**
	 * 获取当前登录用户
	 * @param request
	 * @return 登录用户
	 */
	protected SysUser admin(HttpServletRequest request){
		return (SysUser) request.getSession().getAttribute("user");
	}
	
	/**
	 * 获取当前用户功能权限
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Set<Long> limits(HttpServletRequest request){
		return (Set<Long>) request.getSession().getAttribute("limits");
	}
	
}
