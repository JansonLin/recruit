package com.chen.system.service;

import java.util.List;

import com.chen.system.entity.SysUser;

/**
 * 用户service接口
 * @author chencundeng
 * @version 1.0v 2018年3月17日
 */
public interface SysUserService {
  
	List<SysUser> list();
	
	SysUser find(Long id);
	
}
