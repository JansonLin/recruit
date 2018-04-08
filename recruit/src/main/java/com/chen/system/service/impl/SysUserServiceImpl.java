package com.chen.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chen.system.entity.SysUser;
import com.chen.system.entity.SysUserDepart;
import com.chen.system.entity.SysUserExample;
import com.chen.system.mapper.SysUserDepartMapper;
import com.chen.system.mapper.SysUserMapper;
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
			int upNum = sysUserMapper.updateByPrimaryKey(sysUser);
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
	public boolean saveUserByDepartId(long departId, SysUser sysUser) {
		boolean flag = false;
		int saveNum = sysUserMapper.insert(sysUser);
		if(saveNum>0) {
			flag=true;
		}
		SysUserDepart userDepart = new SysUserDepart();
		userDepart.setSysDepartId(departId);
		userDepart.setSysUserId(sysUser.getId());
		userDepart.setCraeteTime(new Date());
		userDepart.setCrator("chen");
		userDepart.setUpdateTime(new Date());
		userDepart.setUpdator("chen");
		int userDepartNum  = userDepartMapper.insert(userDepart);
		if(userDepartNum<1) {
			flag=false;
		}
		return flag;
	}


}
