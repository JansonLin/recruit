package com.chen.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysRole;
import com.chen.system.entity.SysRoleExample;
import com.chen.system.entity.SysUserRole;
import com.chen.system.entity.SysUserRoleExample;
import com.chen.system.mapper.SysRoleMapper;
import com.chen.system.mapper.SysUserRoleMapper;
import com.chen.system.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysRoleServiceImpl   
 * @Description:TODO 系统角色信息service实现类 
 * @author:chencundeng 
 * @date:   2018年4月9日 下午5:09:44       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{
    
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Override
	public PageInfo<SysRole> page(int pageNum, int pageSize, SysRoleExample example) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> list = sysRoleMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public SysRole find(Long id) {
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
		return sysRole;
	}

	@Override
	public boolean saveOrUpdate(SysRole sysRole) {
		boolean flag = false;

		if (null == sysRole) {
			return flag;
		}

		if (null != sysRole.getId()) {
			int upNum = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
			if (upNum > 0) {
				flag = true;
			}
			return flag;
		}

		int saveNum = sysRoleMapper.insert(sysRole);
		if (saveNum > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deletes(List<Long> id) {
		SysRoleExample example = new SysRoleExample();
		example.or().andIdIn(id);
		int delNum = sysRoleMapper.deleteByExample(example);
		if(delNum<1) {
			return false;
		}
		return true;
	}

	@Override
	public List<SysRole> getUserRole(long userId) {
		List<SysRole> sysRole = sysRoleMapper.getUserRole(userId);
		return sysRole;
	}

	@Override
	public List<SysRole> getDepartRole(long departId) {
		return null;
	}

	

}
