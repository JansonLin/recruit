package com.chen.system.entity;

import java.util.Date;

public class SysResource {

	private Long id;
    
	/**
	 * 资源名称
	 */
    private String resourceName;

    /**
     * 资源编码
     */
    private String resourceCode;

    /**
     * 资源URL
     */
    private String resourceUrl;

    /**
     * 资源logo图片路径
     */
    private String resourceLogo;

    /**
     * 资源层级:0.代表顶级模块 1.功能模块 2.操作方法
     */
    private Boolean resourceLevel;

    /**
     * 上级资源编码
     */
    private String parentResourceCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态：0.无效 1.生效
     */
    private Boolean status;

    /**
     * 是否删除：0.否 1.是
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date createTime;

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

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getResourceLogo() {
        return resourceLogo;
    }

    public void setResourceLogo(String resourceLogo) {
        this.resourceLogo = resourceLogo == null ? null : resourceLogo.trim();
    }

    public Boolean getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(Boolean resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getParentResourceCode() {
        return parentResourceCode;
    }

    public void setParentResourceCode(String parentResourceCode) {
        this.parentResourceCode = parentResourceCode == null ? null : parentResourceCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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