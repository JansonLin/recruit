package com.chen.system.mapper;

import com.chen.system.entity.SysUserDepart;
import com.chen.system.entity.SysUserDepartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:  SysUserDepartMapper   
 * @Description:TODO 内部用户组织中间表信息mapper接口 
 * @author:chencundeng 
 * @date:   2018年4月18日 下午2:48:00       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysUserDepartMapper {
    
	
    long countByExample(SysUserDepartExample example);

   
    int deleteByExample(SysUserDepartExample example);

   
    int deleteByPrimaryKey(Long id);

   
    int insert(SysUserDepart record);

   
    int insertSelective(SysUserDepart record);

    
    List<SysUserDepart> selectByExample(SysUserDepartExample example);

    
    SysUserDepart selectByPrimaryKey(Long id);

   
    int updateByExampleSelective(@Param("record") SysUserDepart record, @Param("example") SysUserDepartExample example);

   
    int updateByExample(@Param("record") SysUserDepart record, @Param("example") SysUserDepartExample example);

    
    int updateByPrimaryKeySelective(SysUserDepart record);

    
    int updateByPrimaryKey(SysUserDepart record);
}