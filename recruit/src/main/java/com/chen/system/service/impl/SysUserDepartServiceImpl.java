package com.chen.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysUserDepart;
import com.chen.system.mapper.SysUserDepartMapper;
import com.chen.system.service.SysUserDepartService;

/**
 * @ClassName:  SysUserDepartServiceImpl   
 * @Description:TODO 用户组织中级表service实现类 
 * @author:chencundeng 
 * @date:   2018年4月4日 下午4:35:59       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Service
public class SysUserDepartServiceImpl implements SysUserDepartService{
    
	@Autowired
	private SysUserDepartMapper userDepartMapper;
	
	@Override
	public boolean save(SysUserDepart sysUserDepart) {
		boolean flag = false;
		int saveNum = userDepartMapper.insert(sysUserDepart);
		if(saveNum>0) {
			flag=true;
		}
		return flag;
	}

}
