package com.chen.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.system.entity.SysOperateLog;
import com.chen.system.entity.SysOperateLogExample;
import com.chen.system.mapper.SysOperateLogMapper;
import com.chen.system.service.SysOperateLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysOperateLogServiceImpl   
 * @Description:TODO 系统日志service实现类 
 * @author:chencundeng 
 * @date:   2018年4月9日 下午3:20:56       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Service
public class SysOperateLogServiceImpl implements SysOperateLogService{
    
	@Autowired
	private SysOperateLogMapper operateLogMapper;
	
	@Override
	public PageInfo<SysOperateLog> page(Integer page, Integer rows, SysOperateLogExample example) {
		PageHelper.startPage(page, rows);
		List<SysOperateLog> list = operateLogMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

}
