package com.chen.system.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.chen.system.entity.SysDepart;
import com.chen.system.entity.SysDepartExample;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysDepartService   
 * @Description:TODO 内部组织信息service接口 
 * @author:chencundeng 
 * @date:   2018年4月2日 下午4:49:41       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysDepartService {
   
	/**
	 * 分页查询组织信息
	 * @param pageNum
	 * @param pageSize
	 * @param sysDepartExample 查询条件
	 * @return
	 */
	PageInfo<SysDepart> page(int pageNum,int pageSize,SysDepartExample sysDepartExample);
	
    PageInfo<SysDepart> page(int pageNum,int pageSize,String parentDepartCode);
	
    /**
     * 根据组织级别查找对于信息
     * @param level 级别
     * @return
     */
    List<SysDepart> findByLevel(Byte level);
    
	List<SysDepart> childByParentCode(String parentDepartCode);
	
	boolean saveOrUpdate(SysDepart sysDepart) throws SQLException;
	
	boolean deletes(List<Long> id) throws SQLException;
	
	/**
	 * 根据编码查询组织信息
	 * @param departCode
	 * @return
	 */
	SysDepart findByCode(String departCode);
	
	/**
	 * 判断组织编码是否存在
	 * @param departCode
	 * @return
	 */
	boolean existByCode(String departCode);
	
}
