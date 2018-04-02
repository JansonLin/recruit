package com.chen.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.common.util.Message;
import com.chen.common.util.Page;
import com.chen.common.vo.TreeVo;

/**
 * @ClassName:  SysDepart   
 * @Description:TODO 内部用户组织架构查询、增加、修改、删除 
 * @author:chencundeng 
 * @date:   2018年4月2日 下午4:18:26       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Controller
@RequestMapping("/system/sysDepart")
public class SysDepart {
   
	@RequestMapping("/main")
	public String main() {
		return "system/depart/depart_main";
	}
	
	
	@RequestMapping("/page")
	@ResponseBody
	public Page<SysDepart> page(HttpServletRequest request, Integer page, Integer rows){
		return null;
	}
    
	@RequestMapping("/tree")
	@ResponseBody
	public List<TreeVo> tree(String id){
		return null;
	}
	
	@RequestMapping("/addip")
	public String addip(ModelMap map) {
		return "system/depart/depart_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(SysDepart depart) {
		return null;
	}
	
	
}










