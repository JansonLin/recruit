package com.chen.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.common.util.Page;
import com.chen.system.entity.SysOperateLog;
import com.chen.system.entity.SysOperateLogExample;
import com.chen.system.service.SysOperateLogService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysOperateLogController   
 * @Description:TODO 系统操作日志 
 * @author:chencundeng 
 * @date:   2018年4月9日 下午2:28:18       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Controller
@RequestMapping("/system/sysOperateLog")
public class SysOperateLogController {
   
	@Autowired
	private SysOperateLogService sysOperateLogService;
	
	@RequestMapping("/main")
	public String main() {
		return "system/log/log_main";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Page<SysOperateLog> page(HttpServletRequest request, Integer page, Integer rows){
		
		SysOperateLogExample example = new SysOperateLogExample();
		if(null!=request.getParameter("operateName")) {
			example.or().andOperateNameLike(request.getParameter("operateName"));
		}
		if(null!=request.getParameter("operateUser")) {
			example.or().andOperateUserEqualTo(request.getParameter("operateUser"));
		}
		
		Page<SysOperateLog> logPage = new Page<>(); 
		
		PageInfo<SysOperateLog> logs = sysOperateLogService.page(page, rows, example);
		if(null!=logs) {
			logPage.setRows(logs.getList());
			logPage.setTotal(logs.getTotal());
		}
		
		return logPage;
		
	}
	
}






