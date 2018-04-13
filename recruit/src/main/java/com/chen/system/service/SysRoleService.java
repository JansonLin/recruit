package com.chen.system.service;

import java.util.List;

import com.chen.system.entity.SysRole;
import com.chen.system.entity.SysRoleExample;
import com.github.pagehelper.PageInfo;

/**
 * 角色信息service接口
 * @author chencundeng
 * @version 1.0v 2018年3月26日
 */
public interface SysRoleService {
   
	/**
	 * 条件获取用户分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param userExample
	 * @return
	 */
	PageInfo<SysRole> page(int pageNum,int pageSize,SysRoleExample example);
	
    SysRole find(Long id);
	
	boolean saveOrUpdate(SysRole sysRole);
	
	boolean deletes(List<Long> id);
	
	/**
	 * 获取用户角色列表
	 * @param userId
	 * @return
	 */
	List<SysRole> getUserRole(long userId); 
	
}
