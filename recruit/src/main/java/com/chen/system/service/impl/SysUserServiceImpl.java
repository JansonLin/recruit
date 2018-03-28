package com.chen.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysUser;
import com.chen.system.mapper.SysUserMapper;
import com.chen.system.service.SysUserService;

/**
 * 用户信息Service实现类
 * @author chencundeng
 * @version 1.0v 2018年3月17日
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public List<SysUser> list() {
		try {
			List<SysUser> users = sysUserMapper.selectByExample(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysUserMapper.selectByExample(null);
	}

	@Override
	public SysUser find(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
    
	
    
	
	
}
