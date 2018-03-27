package com.chen.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserDepartExample {

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserDepartExample() {
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

        public Criteria andSysUserIdIsNull() {
            addCriterion("SYS_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("SYS_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Long value) {
            addCriterion("SYS_USER_ID =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Long value) {
            addCriterion("SYS_USER_ID <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Long value) {
            addCriterion("SYS_USER_ID >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_USER_ID >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Long value) {
            addCriterion("SYS_USER_ID <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_USER_ID <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Long> values) {
            addCriterion("SYS_USER_ID in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Long> values) {
            addCriterion("SYS_USER_ID not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Long value1, Long value2) {
            addCriterion("SYS_USER_ID between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_USER_ID not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdIsNull() {
            addCriterion("SYS_DEPART_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdIsNotNull() {
            addCriterion("SYS_DEPART_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdEqualTo(Long value) {
            addCriterion("SYS_DEPART_ID =", value, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdNotEqualTo(Long value) {
            addCriterion("SYS_DEPART_ID <>", value, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdGreaterThan(Long value) {
            addCriterion("SYS_DEPART_ID >", value, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SYS_DEPART_ID >=", value, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdLessThan(Long value) {
            addCriterion("SYS_DEPART_ID <", value, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdLessThanOrEqualTo(Long value) {
            addCriterion("SYS_DEPART_ID <=", value, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdIn(List<Long> values) {
            addCriterion("SYS_DEPART_ID in", values, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdNotIn(List<Long> values) {
            addCriterion("SYS_DEPART_ID not in", values, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdBetween(Long value1, Long value2) {
            addCriterion("SYS_DEPART_ID between", value1, value2, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andSysDepartIdNotBetween(Long value1, Long value2) {
            addCriterion("SYS_DEPART_ID not between", value1, value2, "sysDepartId");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeIsNull() {
            addCriterion("CRAETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeIsNotNull() {
            addCriterion("CRAETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeEqualTo(Date value) {
            addCriterion("CRAETE_TIME =", value, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeNotEqualTo(Date value) {
            addCriterion("CRAETE_TIME <>", value, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeGreaterThan(Date value) {
            addCriterion("CRAETE_TIME >", value, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRAETE_TIME >=", value, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeLessThan(Date value) {
            addCriterion("CRAETE_TIME <", value, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRAETE_TIME <=", value, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeIn(List<Date> values) {
            addCriterion("CRAETE_TIME in", values, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeNotIn(List<Date> values) {
            addCriterion("CRAETE_TIME not in", values, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeBetween(Date value1, Date value2) {
            addCriterion("CRAETE_TIME between", value1, value2, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCraeteTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRAETE_TIME not between", value1, value2, "craeteTime");
            return (Criteria) this;
        }

        public Criteria andCratorIsNull() {
            addCriterion("CRATOR is null");
            return (Criteria) this;
        }

        public Criteria andCratorIsNotNull() {
            addCriterion("CRATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCratorEqualTo(String value) {
            addCriterion("CRATOR =", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorNotEqualTo(String value) {
            addCriterion("CRATOR <>", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorGreaterThan(String value) {
            addCriterion("CRATOR >", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorGreaterThanOrEqualTo(String value) {
            addCriterion("CRATOR >=", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorLessThan(String value) {
            addCriterion("CRATOR <", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorLessThanOrEqualTo(String value) {
            addCriterion("CRATOR <=", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorLike(String value) {
            addCriterion("CRATOR like", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorNotLike(String value) {
            addCriterion("CRATOR not like", value, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorIn(List<String> values) {
            addCriterion("CRATOR in", values, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorNotIn(List<String> values) {
            addCriterion("CRATOR not in", values, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorBetween(String value1, String value2) {
            addCriterion("CRATOR between", value1, value2, "crator");
            return (Criteria) this;
        }

        public Criteria andCratorNotBetween(String value1, String value2) {
            addCriterion("CRATOR not between", value1, value2, "crator");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("UPDATOR is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("UPDATOR is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("UPDATOR =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("UPDATOR <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("UPDATOR >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATOR >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("UPDATOR <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("UPDATOR <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("UPDATOR like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("UPDATOR not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("UPDATOR in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("UPDATOR not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("UPDATOR between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("UPDATOR not between", value1, value2, "updator");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_user_depart
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
     * This class corresponds to the database table sys_user_depart
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