package com.chen.system.mapper;
import com.chen.system.entity.SysResource;
import com.chen.system.entity.SysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:  SysResourceMapper   
 * @Description:TODO 系统菜单资源 mapper接口 
 * @author:chencundeng 
 * @date:   2018年3月29日 上午10:16:17       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public interface SysResourceMapper {

	long countByExample(SysResourceExample example);

    int deleteByExample(SysResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    List<SysResource> selectByExample(SysResourceExample example);

    SysResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
}