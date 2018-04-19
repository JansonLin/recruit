package com.chen.system.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysResource;
import com.chen.system.entity.SysResourceExample;
import com.chen.system.entity.SysResourceExample.Criteria;
import com.chen.system.mapper.SysResourceMapper;
import com.chen.system.service.SysResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysResourceServiceImpl   
 * @Description:TODO 菜单查询、插入、修改 service实现类 
 * @author:chencundeng 
 * @date:   2018年3月29日 上午10:00:47       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Service
public class SysResourceServiceImpl implements SysResourceService{
    
	@Autowired
	private SysResourceMapper sysResourceMapper;
	
	@Override
	public List<SysResource> list(SysResourceExample example) {
        List<SysResource> rootList = sysResourceMapper.selectByExample(example);
		return rootList;
	}

	@Override
	public List<SysResource> childByParentId(Long parentId) {
		SysResourceExample example = new SysResourceExample();
		example.or().andparentIdEqualTo(parentId);
		List<SysResource> childList = sysResourceMapper.selectByExample(example);
	    return childList;
	}

	@Override
	public boolean saveOrUpdate(SysResource sysResource) throws SQLException {
        
		boolean flag = false;
		
		if(null==sysResource) {
		   return flag;
		}
		
		if(null!=sysResource.getId()) {
			int upNum = sysResourceMapper.updateByPrimaryKey(sysResource);
			if(upNum>0) {
				flag=true;				
			}
			return flag;
		}
		
		int saveNum = sysResourceMapper.insert(sysResource);
		if(saveNum>0) {
			flag=true;		
		}
		
		return flag;
		
	}


	@Override
	public boolean deletes(List<Long> id) throws SQLException {

		boolean flag = false;
	
		SysResourceExample example = new SysResourceExample();
		example.or().andIdIn(id);
		int delNum = sysResourceMapper.deleteByExample(example);
	    if(delNum>0) {  
	    	flag = true;
	    }
	 
	    return flag;
	    
	}

	@Override
	public PageInfo<SysResource> page(int pageNum,int pageSize,long pid) {
		PageHelper.startPage(pageNum, pageSize);
		SysResourceExample example = new SysResourceExample();
		example.or().andparentIdEqualTo(pid);
        List<SysResource> list = sysResourceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}
	
	
	
	

}
