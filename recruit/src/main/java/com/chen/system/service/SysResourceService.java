package com.chen.system.service;

import java.sql.SQLException;
import java.util.List;

import com.chen.system.entity.SysResource;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysResourceServie   
 * @Description:TODO 菜单资源service接口 
 * @author:chencundeng 
 * @date:   2018年3月29日 上午9:58:45       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysResourceService {
    
	PageInfo<SysResource> page(int pageNum,int pageSize,long pid);
	
	/**
	 * 获取根菜单列表
	 * @return
	 */
	List<SysResource> rootTree();
	
	List<SysResource> childByParentId(Long parentId);
	
	boolean saveOrUpdate(SysResource sysResource) throws SQLException;
	
	boolean deletes(List<Long> id) throws SQLException;
	
}
