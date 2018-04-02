package com.chen.system.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chen.system.entity.SysDepart;
import com.chen.system.entity.SysDepartExample;
import com.chen.system.entity.SysResource;
import com.chen.system.entity.SysResourceExample;
import com.chen.system.mapper.SysDepartMapper;
import com.chen.system.service.SysDepartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: SysDepartServiceImpl
 * @Description:TODO 组织架构信息service实现类
 * @author:chencundeng
 * @date: 2018年4月2日 下午4:53:09
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public class SysDepartServiceImpl implements SysDepartService {

	@Autowired
	private SysDepartMapper sysDepartMapper;

	@Override
	public PageInfo<SysDepart> page(int pageNum, int pageSize, String parentDepartCode) {
		PageHelper.startPage(pageNum, pageSize);
		SysDepartExample example = new SysDepartExample();
		example.or().andParentDepartCodeEqualTo(parentDepartCode);
        List<SysDepart> list = sysDepartMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<SysDepart> childByParentId(String parentDepartCode) {
		SysDepartExample example = new SysDepartExample();
		example.or().andParentDepartCodeEqualTo(parentDepartCode);
        List<SysDepart> list = sysDepartMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean saveOrUpdate(SysDepart sysDepart) throws SQLException {
		
		boolean flag = false;

		if (null == sysDepart) {
			return flag;
		}

		if (null != sysDepart.getId()) {
			int upNum = sysDepartMapper.updateByPrimaryKey(sysDepart);
			if (upNum > 0) {
				flag = true;
			}
			return flag;
		}

		int saveNum = sysDepartMapper.insert(sysDepart);
		if (saveNum > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deletes(List<Long> id) throws SQLException {
		
		boolean flag = false;

		SysDepartExample example = new SysDepartExample();
		example.or().andIdIn(id);
		int delNum = sysDepartMapper.deleteByExample(example);
		if (delNum > 0) {
			flag = true;
		}

		return flag;
		
	}

}
