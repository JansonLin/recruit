package com.chen.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysUserRole;
import com.chen.system.entity.SysUserRoleExample;
import com.chen.system.mapper.SysUserRoleMapper;
import com.chen.system.service.SysUserRoleService;

/**
 * @ClassName:  SysUserRoleServiceImpl   
 * @Description:TODO 用户、角色中间表service实现类 
 * @author:chencundeng 
 * @date:   2018年4月13日 下午4:18:05       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Override
	public boolean save(SysUserRole userRole) {
        boolean flag = false;
        int saveNum = userRoleMapper.insert(userRole);
        if(saveNum>0) {
        	flag=true;
        }
		return flag;
	}

	@Override
	public boolean deletes(SysUserRoleExample example) {
		boolean flag = false;
		int delNum = userRoleMapper.deleteByExample(example);
		if(delNum>0) {
			flag = true;
		}
		return flag;
	}

}
