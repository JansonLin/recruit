package com.chen.system.mapper;

import java.util.List;

import com.chen.system.entity.SysOperateLog;
import com.chen.system.entity.SysOperateLogExample;
import com.chen.system.entity.SysRole;

/**
 * @ClassName:  SysOperateLogMapper   
 * @Description:TODO 系统操作日志mapper接口 
 * @author:chencundeng 
 * @date:   2018年4月9日 下午3:32:25       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysOperateLogMapper {

	long countByExample(SysOperateLogExample example);
    
	int insert(SysRole record);
	
    List<SysOperateLog> selectByExample(SysOperateLogExample example);

    SysOperateLog selectByPrimaryKey(Long id);

}