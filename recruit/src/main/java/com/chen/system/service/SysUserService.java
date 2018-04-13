package com.chen.system.service;

import java.util.List;
import java.util.Map;

import com.chen.system.entity.SysUser;
import com.chen.system.entity.SysUserExample;
import com.github.pagehelper.PageInfo;

/**
 * 用户service接口
 * @author chencundeng
 * @version 1.0v 2018年3月17日
 */
public interface SysUserService {
    
	/**
	 * 条件获取某组织所属用户列表
	 * @param pageNum
	 * @param pageSize
	 * @param map (departId、phone、status equal 查询  ；userName like 查询)
	 * @return
	 */
	PageInfo<SysUser> page(int pageNum,int pageSize,Map<String, Object> map);
	
	/**
	 * 条件获取用户分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param userExample
	 * @return
	 */
	PageInfo<SysUser> page(int pageNum,int pageSize,SysUserExample userExample);
	
	PageInfo<SysUser> page(int pageNum,int pageSize);
	
	List<SysUser> list();
	
	SysUser find(Long id);
	
	boolean saveOrUpdate(SysUser sysUser);
	
	boolean deletes(Long[] id);
	
	/**
	 * 保存用户基本信息、所在组织信息、角色信息
	 * @param departId
	 * @param sysUser
	 * @param roleIds
	 * @return
	 */
	boolean saveUserByDepartId(long departId,SysUser sysUser,Long[] roleIds);
	
}
