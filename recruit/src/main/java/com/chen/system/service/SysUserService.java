package com.chen.system.service;

import java.util.List;

import com.chen.system.entity.SysUser;
import com.github.pagehelper.PageInfo;

/**
 * 用户service接口
 * @author chencundeng
 * @version 1.0v 2018年3月17日
 */
public interface SysUserService {
    
	PageInfo<SysUser> page(int pageNum,int pageSize);
	
	List<SysUser> list();
	
	SysUser find(Long id);
	
	boolean saveOrUpdate(SysUser sysUser);
	
	boolean deletes(Long[] id);
	
}
