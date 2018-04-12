package com.chen.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:  SysCommonController   
 * @Description:TODO 系统管理公共controller类 
 * @author:chencundeng 
 * @date:   2018年4月12日 下午5:16:09       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Controller
@RequestMapping("/system/sysCommon")
public class SysCommonController {
  
	@RequestMapping("/empowerip")
	public String empowerip() {
		return "system/common/role_empower";
	}
	
}
