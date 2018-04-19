package com.chen.system.mapper;

import com.chen.system.entity.SysDepart;
import com.chen.system.entity.SysDepartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDepartMapper {

	long countByExample(SysDepartExample example);

    int deleteByExample(SysDepartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDepart record);

    int insertSelective(SysDepart record);

    List<SysDepart> selectByExample(SysDepartExample example);

    SysDepart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDepart record, @Param("example") SysDepartExample example);

    int updateByExample(@Param("record") SysDepart record, @Param("example") SysDepartExample example);

    int updateByPrimaryKeySelective(SysDepart record);

    int updateByPrimaryKey(SysDepart record);
    
    /**
     * 查找用户所在组织
     * @param userId
     * @return
     */
    List<SysDepart> getUserDepart(@Param("userId")long userId);
    
}



