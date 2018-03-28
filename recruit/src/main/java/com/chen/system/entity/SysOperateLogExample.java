package com.chen.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysOperateLogExample {

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysOperateLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOperateNameIsNull() {
            addCriterion("OPERATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperateNameIsNotNull() {
            addCriterion("OPERATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperateNameEqualTo(String value) {
            addCriterion("OPERATE_NAME =", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotEqualTo(String value) {
            addCriterion("OPERATE_NAME <>", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameGreaterThan(String value) {
            addCriterion("OPERATE_NAME >", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_NAME >=", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLessThan(String value) {
            addCriterion("OPERATE_NAME <", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_NAME <=", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLike(String value) {
            addCriterion("OPERATE_NAME like", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotLike(String value) {
            addCriterion("OPERATE_NAME not like", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameIn(List<String> values) {
            addCriterion("OPERATE_NAME in", values, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotIn(List<String> values) {
            addCriterion("OPERATE_NAME not in", values, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameBetween(String value1, String value2) {
            addCriterion("OPERATE_NAME between", value1, value2, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotBetween(String value1, String value2) {
            addCriterion("OPERATE_NAME not between", value1, value2, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateUserIsNull() {
            addCriterion("OPERATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIsNotNull() {
            addCriterion("OPERATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andOperateUserEqualTo(String value) {
            addCriterion("OPERATE_USER =", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserNotEqualTo(String value) {
            addCriterion("OPERATE_USER <>", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserGreaterThan(String value) {
            addCriterion("OPERATE_USER >", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_USER >=", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserLessThan(String value) {
            addCriterion("OPERATE_USER <", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_USER <=", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserLike(String value) {
            addCriterion("OPERATE_USER like", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserNotLike(String value) {
            addCriterion("OPERATE_USER not like", value, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserIn(List<String> values) {
            addCriterion("OPERATE_USER in", values, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserNotIn(List<String> values) {
            addCriterion("OPERATE_USER not in", values, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserBetween(String value1, String value2) {
            addCriterion("OPERATE_USER between", value1, value2, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateUserNotBetween(String value1, String value2) {
            addCriterion("OPERATE_USER not between", value1, value2, "operateUser");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("OPERATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("OPERATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("OPERATE_TIME =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("OPERATE_TIME <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("OPERATE_TIME >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("OPERATE_TIME <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATE_TIME <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("OPERATE_TIME in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("OPERATE_TIME not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATE_TIME not between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNull() {
            addCriterion("OPERATE_IP is null");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNotNull() {
            addCriterion("OPERATE_IP is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIpEqualTo(String value) {
            addCriterion("OPERATE_IP =", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotEqualTo(String value) {
            addCriterion("OPERATE_IP <>", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThan(String value) {
            addCriterion("OPERATE_IP >", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_IP >=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThan(String value) {
            addCriterion("OPERATE_IP <", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_IP <=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLike(String value) {
            addCriterion("OPERATE_IP like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotLike(String value) {
            addCriterion("OPERATE_IP not like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpIn(List<String> values) {
            addCriterion("OPERATE_IP in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotIn(List<String> values) {
            addCriterion("OPERATE_IP not in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpBetween(String value1, String value2) {
            addCriterion("OPERATE_IP between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotBetween(String value1, String value2) {
            addCriterion("OPERATE_IP not between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("DELETED is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Byte value) {
            addCriterion("DELETED =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Byte value) {
            addCriterion("DELETED <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Byte value) {
            addCriterion("DELETED >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("DELETED >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Byte value) {
            addCriterion("DELETED <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("DELETED <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Byte> values) {
            addCriterion("DELETED in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Byte> values) {
            addCriterion("DELETED not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Byte value1, Byte value2) {
            addCriterion("DELETED between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("DELETED not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_operate_log
     *
     * @mbg.generated do_not_delete_during_merge Sat Mar 24 10:05:29 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_operate_log
     *
     * @mbg.generated Sat Mar 24 10:05:29 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}