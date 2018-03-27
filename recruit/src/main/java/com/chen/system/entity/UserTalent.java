package com.chen.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 普通会员实体类
 * @author chencundeng
 * @version 1.0v 2018年3月26日
 */
public class UserTalent implements Serializable{

	private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 账户名称
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 注册方式：1.手机 2.邮箱
     */
    private Boolean registeType;

    /**
     * 状态：0.未激活 1.正常
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getRegisteType() {
        return registeType;
    }

    public void setRegisteType(Boolean registeType) {
        this.registeType = registeType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}