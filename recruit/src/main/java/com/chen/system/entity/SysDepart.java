package com.chen.system.entity;

import java.util.Date;

public class SysDepart {

	private Long id;
    
	/**
	 * 部门名称
	 */
    private String departName;
    
    /**
     * 部门编码
     */
    private String departCode;
    
    /**
     * 部门级别
     */
    private Byte departLevel;
    
    /**
     * 上级部门名称
     */
    private String parentDepartName;
    
    /**
     * 上级部门编码
     */
    private String parentDepartCode;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 状态：0.异常 1.正常
     */
    private Byte status;
    
    /**
     * 是否删除：0.否 1.是
     */
    private Byte deleted;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**创建人
     * 
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

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode == null ? null : departCode.trim();
    }

    public Byte getDepartLevel() {
        return departLevel;
    }

    public void setDepartLevel(Byte departLevel) {
        this.departLevel = departLevel;
    }

    public String getParentDepartName() {
        return parentDepartName;
    }

    public void setParentDepartName(String parentDepartName) {
        this.parentDepartName = parentDepartName == null ? null : parentDepartName.trim();
    }

    public String getParentDepartCode() {
        return parentDepartCode;
    }

    public void setParentDepartCode(String parentDepartCode) {
        this.parentDepartCode = parentDepartCode == null ? null : parentDepartCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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