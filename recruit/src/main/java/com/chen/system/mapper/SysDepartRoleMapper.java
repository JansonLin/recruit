package com.chen.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.system.entity.SysDepartRole;
import com.chen.system.entity.SysDepartRoleExample;

public interface SysDepartRoleMapper {

	long countByExample(SysDepartRoleExample example);

    int deleteByExample(SysDepartRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDepartRole record);

    int insertSelective(SysDepartRole record);

    List<SysDepartRole> selectByExample(SysDepartRoleExample example);

    SysDepartRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDepartRole record, @Param("example") SysDepartRoleExample example);

    int updateByExample(@Param("record") SysDepartRole record, @Param("example") SysDepartRoleExample example);

    int updateByPrimaryKeySelective(SysDepartRole record);

    int updateByPrimaryKey(SysDepartRole record);
}