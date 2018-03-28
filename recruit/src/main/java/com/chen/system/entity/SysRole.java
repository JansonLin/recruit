package com.chen.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 * @author chencundeng
 * @version 1.0v 2018年3月26日
 */
public class SysRole implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String ramrak;

    /**
     * 状态：0.无效 1.正常
     */
    private Boolean status;

    /**
     * 是否删除：0.否 1.是
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date craeteTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRamrak() {
        return ramrak;
    }

    public void setRamrak(String ramrak) {
        this.ramrak = ramrak == null ? null : ramrak.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCraeteTime() {
        return craeteTime;
    }

    public void setCraeteTime(Date craeteTime) {
        this.craeteTime = craeteTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }
}