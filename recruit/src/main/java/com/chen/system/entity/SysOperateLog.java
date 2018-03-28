package com.chen.system.entity;

import java.util.Date;

public class SysOperateLog {

	private Long id;
    
	/**
	 * 操作名称
	 */
    private String operateName;
    
    /**
	 * 操作人
	 */
    private String operateUser;
    
    /**
	 * 操作时间
	 */
    private Date operateTime;
    
    /**
	 * 操作IP
	 */
    private String operateIp;
    
    /**
	 * 是否删除：0.否 1.是
	 */
    private Byte deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName == null ? null : operateName.trim();
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser == null ? null : operateUser.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}