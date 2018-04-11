package com.chen.system.service;

import com.chen.system.entity.SysOperateLog;
import com.chen.system.entity.SysOperateLogExample;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysOperateLogService   
 * @Description:TODO 系统操作日志service接口 
 * @author:chencundeng 
 * @date:   2018年4月9日 下午2:30:39       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysOperateLogService {
  
	PageInfo<SysOperateLog> page(Integer page, Integer rows,SysOperateLogExample example);
	
}
