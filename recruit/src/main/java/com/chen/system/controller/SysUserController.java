package com.chen.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.common.util.ConstantUtil;
import com.chen.common.util.Message;
import com.chen.common.util.Page;
import com.chen.system.entity.SysUser;
import com.chen.system.service.SysUserService;
import com.github.pagehelper.PageInfo;

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
	public String main() {
		return "system/user/user_main";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Page<SysUser> page(HttpServletRequest request, Integer page, Integer rows){
		
		Map<String, Object> map = new HashMap<>();
		if (null == page) {
			page = ConstantUtil.PAGE_NUMBER;
		}
		if (null == rows) {
			rows = ConstantUtil.PAGE_SIZE;
		}
		if(null!=request.getParameter("departId")) {
			map.put("departId", request.getParameter("departId"));
		}
		if(null!=request.getParameter("phone")) {
			map.put("phone", request.getParameter("phone"));
		}
		if(null!=request.getParameter("status")) {
			map.put("status", request.getParameter("status"));
		}
		if(null!=request.getParameter("userName")) {
			map.put("userName", request.getParameter("userName"));
		}
		
        Page<SysUser> userPage = new Page<>(); 		
		PageInfo<SysUser> users = sysUserService.page(page, rows, map);
		if(null!=users) {
			userPage.setRows(users.getList());
			userPage.setTotal(users.getTotal());
		}
		
		return userPage;
		
	}
	
	@RequestMapping("/addip")
	public String addip(String departId,ModelMap map) {
		map.put("departId", departId);
		return "system/user/user_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(long departId,SysUser sysUser) {
		if(null==sysUser) {
			return Message.error("数据异常!");
		}
		boolean flag = sysUserService.saveUserByDepartId(departId, sysUser);
		if(!flag) {
			return Message.error("用户信息添加成功！");
		}
		return Message.success("用户信息添加成功！");
	}
	
}






