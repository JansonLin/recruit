package com.chen.system.service;

import java.sql.SQLException;
import java.util.List;

import com.chen.system.entity.SysDepart;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysDepartService   
 * @Description:TODO 内部组织信息service接口 
 * @author:chencundeng 
 * @date:   2018年4月2日 下午4:49:41       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysDepartService {
  
    PageInfo<SysDepart> page(int pageNum,int pageSize,String parentDepartCode);
	
	List<SysDepart> childByParentId(String parentDepartCode);
	
	boolean saveOrUpdate(SysDepart sysDepart) throws SQLException;
	
	boolean deletes(List<Long> id) throws SQLException;
	
}
