package com.chen.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysResource;
import com.chen.system.entity.SysResourceExample;
import com.chen.system.entity.SysUser;
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

}
