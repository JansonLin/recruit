package com.chen.common.entity;

import java.util.Date;

public class DicSysType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic_sys_type.ID
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic_sys_type.NAME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic_sys_type.STATUS
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic_sys_type.REMARK
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic_sys_type.CREATE_TIME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic_sys_type.UPDATE_TIME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic_sys_type.ID
     *
     * @return the value of dic_sys_type.ID
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic_sys_type.ID
     *
     * @param id the value for dic_sys_type.ID
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic_sys_type.NAME
     *
     * @return the value of dic_sys_type.NAME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic_sys_type.NAME
     *
     * @param name the value for dic_sys_type.NAME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic_sys_type.STATUS
     *
     * @return the value of dic_sys_type.STATUS
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic_sys_type.STATUS
     *
     * @param status the value for dic_sys_type.STATUS
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic_sys_type.REMARK
     *
     * @return the value of dic_sys_type.REMARK
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic_sys_type.REMARK
     *
     * @param remark the value for dic_sys_type.REMARK
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic_sys_type.CREATE_TIME
     *
     * @return the value of dic_sys_type.CREATE_TIME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic_sys_type.CREATE_TIME
     *
     * @param createTime the value for dic_sys_type.CREATE_TIME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic_sys_type.UPDATE_TIME
     *
     * @return the value of dic_sys_type.UPDATE_TIME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic_sys_type.UPDATE_TIME
     *
     * @param updateTime the value for dic_sys_type.UPDATE_TIME
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}