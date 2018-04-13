package com.chen.system.mapper;

import com.chen.system.entity.SysRole;
import com.chen.system.entity.SysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:  SysRoleMapper   
 * @Description:TODO  系统角色mapper接口
 * @author:chencundeng 
 * @date:   2018年4月11日 上午10:31:23       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysRoleMapper {

	long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    /**
     * 根据用户ID获取所属角色列表
     * @param userId 用户ID
     * @return
     */
    List<SysRole> getUserRole(@Param("userId") long userId);
    
}