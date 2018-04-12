package com.chen.system.mapper;

import com.chen.system.entity.SysRoleDepart;
import com.chen.system.entity.SysRoleDepartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:  SysRoleDepartMapper   
 * @Description:TODO 系统角色组织中间表mapper接口 
 * @author:chencundeng 
 * @date:   2018年4月12日 下午4:47:17       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysRoleDepartMapper {

	long countByExample(SysRoleDepartExample example);

    int deleteByExample(SysRoleDepartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDepart record);

    int insertSelective(SysRoleDepart record);

    List<SysRoleDepart> selectByExample(SysRoleDepartExample example);

    SysRoleDepart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleDepart record, @Param("example") SysRoleDepartExample example);

    int updateByExample(@Param("record") SysRoleDepart record, @Param("example") SysRoleDepartExample example);

    int updateByPrimaryKeySelective(SysRoleDepart record);

    int updateByPrimaryKey(SysRoleDepart record);
}