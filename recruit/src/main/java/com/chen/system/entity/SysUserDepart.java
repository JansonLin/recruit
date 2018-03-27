package com.chen.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户组织中间表
 * @author chencundeng
 * @version 1.0v 2018年3月26日
 */
public class SysUserDepart implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

    /**
     *
     */
    private Long sysUserId;

    /**
     *
     */
    private Long sysDepartId;

    /**
     *
     */
    private Date craeteTime;

    /**
     *
     */
    private String crator;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private String updator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysDepartId() {
        return sysDepartId;
    }

    public void setSysDepartId(Long sysDepartId) {
        this.sysDepartId = sysDepartId;
    }

    public Date getCraeteTime() {
        return craeteTime;
    }

    public void setCraeteTime(Date craeteTime) {
        this.craeteTime = craeteTime;
    }

    public String getCrator() {
        return crator;
    }

    public void setCrator(String crator) {
        this.crator = crator == null ? null : crator.trim();
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