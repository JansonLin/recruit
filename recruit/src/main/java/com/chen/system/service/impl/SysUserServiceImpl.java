package com.chen.system.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chen.common.util.Md5Util;
import com.chen.system.entity.SysRole;
import com.chen.system.entity.SysUser;
import com.chen.system.entity.SysUserDepart;
import com.chen.system.entity.SysUserExample;
import com.chen.system.entity.SysUserRole;
import com.chen.system.mapper.SysUserDepartMapper;
import com.chen.system.mapper.SysUserMapper;
import com.chen.system.mapper.SysUserRoleMapper;
import com.chen.system.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户信息Service实现类
 * 
 * @author chencundeng
 * @version 1.0v 2018年3月17日
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
    
	@Autowired
	private SysUserDepartMapper userDepartMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
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

	@Override
	public PageInfo<SysUser> page(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> list = sysUserMapper.selectByExample(null);
		return new PageInfo<>(list);
	}

	@Override
	public boolean saveOrUpdate(SysUser sysUser) {
		
		boolean flag = false;

		if (null == sysUser) {
			return flag;
		}

		if (null != sysUser.getId()) {
			int upNum = sysUserMapper.updateByPrimaryKeySelective(sysUser);
			if (upNum > 0) {
				flag = true;
			}
			return flag;
		}

		int saveNum = sysUserMapper.insert(sysUser);
		if (saveNum > 0) {
			flag = true;
		}

		return flag;
		
	}

	@Override
	public boolean deletes(Long[] id) {
		return false;
	}

	@Override
	public PageInfo<SysUser> page(int pageNum, int pageSize, SysUserExample userExample) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> list = sysUserMapper.selectByExample(userExample);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<SysUser> page(int pageNum, int pageSize, Map<String, Object> map) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> list = sysUserMapper.list(map);
		return new PageInfo<>(list);
	}
    
	@Transactional
	@Override
	public boolean saveUserByDepartId(long departId, SysUser sysUser,Long[] roleIds) {
		
		boolean flag = false;
		
		try {
			String password = Md5Util.EncoderByMd5(sysUser.getPassword());
			sysUser.setPassword(password);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int saveNum = sysUserMapper.insert(sysUser);
		if(saveNum>0) {
			flag=true;
		}
		
		//保存用户组织关联信息
		SysUserDepart userDepart = new SysUserDepart();
		userDepart.setSysDepartId(departId);
		userDepart.setSysUserId(sysUser.getId());
		userDepart.setCraeteTime(sysUser.getCreateTime());
		userDepart.setCrator(sysUser.getCreator());
		userDepart.setUpdateTime(sysUser.getUpdateTime());
		userDepart.setUpdator(sysUser.getUpdator());
		int userDepartNum  = userDepartMapper.insert(userDepart);
		if(userDepartNum<1) {
			flag=false;
		}
		
		if(null!=roleIds) {
			for(int i=0;i<roleIds.length;i++) {
				SysUserRole userRole = new SysUserRole();
				userRole.setSysRoleId(roleIds[i]);
				userRole.setSysUserId(sysUser.getId());
				userRole.setCreateTime(new Date());
				userRole.setCreator(sysUser.getCreator());
				userRole.setUpdateTime(new Date());
				userRole.setUpdator(sysUser.getUpdator());
				int userRoleNum = userRoleMapper.insert(userRole);
				if(userRoleNum<1) {
					flag = false;
				}
			}
		}
		
		return flag;
		
	}


}
