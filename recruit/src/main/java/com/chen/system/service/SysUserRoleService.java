package com.chen.system.service;

import com.chen.system.entity.SysUserRole;
import com.chen.system.entity.SysUserRoleExample;

/**
 * @ClassName:  SysUserRoleService   
 * @Description:TODO  用户角色中间表service接口
 * @author:chencundeng 
 * @date:   2018年4月13日 下午4:14:25       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysUserRoleService {
  
	boolean save(SysUserRole userRole);
	
	boolean deletes(SysUserRoleExample example);
	
}
