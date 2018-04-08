package com.chen.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chen.system.entity.SysUser;
import com.chen.system.entity.SysUserExample;

/**
 * @ClassName:  SysUserMapper   
 * @Description:TODO 内部用户信息mapper接口 
 * @author:chencundeng 
 * @date:   2018年4月4日 下午2:48:00       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysUserMapper {
    
	long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    /**
     * 条件查询用户列表信息
     * @param map (departId、phone、status equal 查询  ；userName like 查询)
     * @return
     */
    List<SysUser> list(Map<String, Object> map);
    
}









