package com.chen.system.entity;

import java.util.Date;

/**
 * @ClassName:  SysRoleDepart   
 * @Description:TODO 角色组织中间表 
 * @author:chencundeng 
 * @date:   2018年4月12日 下午4:35:52       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public class SysRoleDepart {

	private Long id;

    private Long sysRoleId;

    private Long sysDepartId;

    private String creator;

    private Date createTime;
    
    /**
     * 是否删除：0.否 1.是
     */
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Long getSysDepartId() {
        return sysDepartId;
    }

    public void setSysDepartId(Long sysDepartId) {
        this.sysDepartId = sysDepartId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}