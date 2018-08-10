 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.hyf.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户帐号信息 三要素校验手机号<br/>
 * @author real code generator
 * date:2018-07-23 17:35:54
 */
public class Example {
    /** 排序字段**/
    protected String orderByClause;

    /** 查询条数**/
    protected int paginLimit;

    /** 查询开始数**/
    protected int paginOffset;

    /** 过滤重复数据**/
    protected boolean distinct;

    /** 查询条件**/
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     *
     * @param paginLimit
     */
    public void setPaginLimit(int paginLimit) {
        this.paginLimit = paginLimit;
    }

    /** 
     *
     */
    public int getPaginLimit() {
        return paginLimit;
    }

    /** 
     *
     * @param paginOffset
     */
    public void setPaginOffset(int paginOffset) {
        this.paginOffset = paginOffset;
    }

    /** 
     *
     */
    public int getPaginOffset() {
        return paginOffset;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 用户帐号信息userprofile的基本动态SQL对象.
     */
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

        public Criteria andUserIDIsNull() {
            addCriterion("UserID is null");
            return (Criteria) this;
        }

        public Criteria andUserIDIsNotNull() {
            addCriterion("UserID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIDEqualTo(String value) {
            addCriterion("UserID =", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDNotEqualTo(String value) {
            addCriterion("UserID <>", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDGreaterThan(String value) {
            addCriterion("UserID >", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDGreaterThanOrEqualTo(String value) {
            addCriterion("UserID >=", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDLessThan(String value) {
            addCriterion("UserID <", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDLessThanOrEqualTo(String value) {
            addCriterion("UserID <=", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDLike(String value) {
            addCriterion("UserID like", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDNotLike(String value) {
            addCriterion("UserID not like", value, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDIn(List<String> values) {
            addCriterion("UserID in", values, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDNotIn(List<String> values) {
            addCriterion("UserID not in", values, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDBetween(String value1, String value2) {
            addCriterion("UserID between", value1, value2, "userID");
            return (Criteria) this;
        }

        public Criteria andUserIDNotBetween(String value1, String value2) {
            addCriterion("UserID not between", value1, value2, "userID");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("PhoneNum is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("PhoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("PhoneNum =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("PhoneNum <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("PhoneNum >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("PhoneNum >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("PhoneNum <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("PhoneNum <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("PhoneNum like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("PhoneNum not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("PhoneNum in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("PhoneNum not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("PhoneNum between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("PhoneNum not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("Password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("Password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("Password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("Password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("Password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("Password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("Password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("Password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("Password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("Password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("Password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("Password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("Password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNull() {
            addCriterion("OnlineStatus is null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNotNull() {
            addCriterion("OnlineStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusEqualTo(String value) {
            addCriterion("OnlineStatus =", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotEqualTo(String value) {
            addCriterion("OnlineStatus <>", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThan(String value) {
            addCriterion("OnlineStatus >", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThanOrEqualTo(String value) {
            addCriterion("OnlineStatus >=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThan(String value) {
            addCriterion("OnlineStatus <", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThanOrEqualTo(String value) {
            addCriterion("OnlineStatus <=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLike(String value) {
            addCriterion("OnlineStatus like", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotLike(String value) {
            addCriterion("OnlineStatus not like", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIn(List<String> values) {
            addCriterion("OnlineStatus in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotIn(List<String> values) {
            addCriterion("OnlineStatus not in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusBetween(String value1, String value2) {
            addCriterion("OnlineStatus between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotBetween(String value1, String value2) {
            addCriterion("OnlineStatus not between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateIsNull() {
            addCriterion("OnlineStatusUpdate is null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateIsNotNull() {
            addCriterion("OnlineStatusUpdate is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate =", value, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateNotEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate <>", value, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateGreaterThan(Date value) {
            addCriterion("OnlineStatusUpdate >", value, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate >=", value, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateLessThan(Date value) {
            addCriterion("OnlineStatusUpdate <", value, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateLessThanOrEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate <=", value, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateIn(List<Date> values) {
            addCriterion("OnlineStatusUpdate in", values, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateNotIn(List<Date> values) {
            addCriterion("OnlineStatusUpdate not in", values, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateBetween(Date value1, Date value2) {
            addCriterion("OnlineStatusUpdate between", value1, value2, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusUpdateNotBetween(Date value1, Date value2) {
            addCriterion("OnlineStatusUpdate not between", value1, value2, "onlineStatusUpdate");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNull() {
            addCriterion("RegDate is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("RegDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(Date value) {
            addCriterion("RegDate =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(Date value) {
            addCriterion("RegDate <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(Date value) {
            addCriterion("RegDate >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RegDate >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(Date value) {
            addCriterion("RegDate <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(Date value) {
            addCriterion("RegDate <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<Date> values) {
            addCriterion("RegDate in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<Date> values) {
            addCriterion("RegDate not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(Date value1, Date value2) {
            addCriterion("RegDate between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(Date value1, Date value2) {
            addCriterion("RegDate not between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("Amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("Amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("Amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("Amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("Amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("Amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("Amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("Amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIsNull() {
            addCriterion("FrozenAmount is null");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIsNotNull() {
            addCriterion("FrozenAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount =", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount <>", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountGreaterThan(BigDecimal value) {
            addCriterion("FrozenAmount >", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount >=", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountLessThan(BigDecimal value) {
            addCriterion("FrozenAmount <", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount <=", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIn(List<BigDecimal> values) {
            addCriterion("FrozenAmount in", values, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotIn(List<BigDecimal> values) {
            addCriterion("FrozenAmount not in", values, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FrozenAmount between", value1, value2, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FrozenAmount not between", value1, value2, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andHlcIdIsNull() {
            addCriterion("hlc_id is null");
            return (Criteria) this;
        }

        public Criteria andHlcIdIsNotNull() {
            addCriterion("hlc_id is not null");
            return (Criteria) this;
        }

        public Criteria andHlcIdEqualTo(Long value) {
            addCriterion("hlc_id =", value, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdNotEqualTo(Long value) {
            addCriterion("hlc_id <>", value, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdGreaterThan(Long value) {
            addCriterion("hlc_id >", value, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hlc_id >=", value, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdLessThan(Long value) {
            addCriterion("hlc_id <", value, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdLessThanOrEqualTo(Long value) {
            addCriterion("hlc_id <=", value, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdIn(List<Long> values) {
            addCriterion("hlc_id in", values, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdNotIn(List<Long> values) {
            addCriterion("hlc_id not in", values, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdBetween(Long value1, Long value2) {
            addCriterion("hlc_id between", value1, value2, "hlcId");
            return (Criteria) this;
        }

        public Criteria andHlcIdNotBetween(Long value1, Long value2) {
            addCriterion("hlc_id not between", value1, value2, "hlcId");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("data_source is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("data_source is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(Integer value) {
            addCriterion("data_source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(Integer value) {
            addCriterion("data_source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(Integer value) {
            addCriterion("data_source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(Integer value) {
            addCriterion("data_source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(Integer value) {
            addCriterion("data_source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<Integer> values) {
            addCriterion("data_source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<Integer> values) {
            addCriterion("data_source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(Integer value1, Integer value2) {
            addCriterion("data_source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("data_source not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("Source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("Source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("Source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("Source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("Source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("Source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("Source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("Source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("Source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("Source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("Source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("Source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("Source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("Source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("referee is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("referee is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(String value) {
            addCriterion("referee =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(String value) {
            addCriterion("referee <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(String value) {
            addCriterion("referee >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(String value) {
            addCriterion("referee >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(String value) {
            addCriterion("referee <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(String value) {
            addCriterion("referee <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLike(String value) {
            addCriterion("referee like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotLike(String value) {
            addCriterion("referee not like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<String> values) {
            addCriterion("referee in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<String> values) {
            addCriterion("referee not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(String value1, String value2) {
            addCriterion("referee between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(String value1, String value2) {
            addCriterion("referee not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andUsrChannelIsNull() {
            addCriterion("usrChannel is null");
            return (Criteria) this;
        }

        public Criteria andUsrChannelIsNotNull() {
            addCriterion("usrChannel is not null");
            return (Criteria) this;
        }

        public Criteria andUsrChannelEqualTo(String value) {
            addCriterion("usrChannel =", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelNotEqualTo(String value) {
            addCriterion("usrChannel <>", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelGreaterThan(String value) {
            addCriterion("usrChannel >", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelGreaterThanOrEqualTo(String value) {
            addCriterion("usrChannel >=", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelLessThan(String value) {
            addCriterion("usrChannel <", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelLessThanOrEqualTo(String value) {
            addCriterion("usrChannel <=", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelLike(String value) {
            addCriterion("usrChannel like", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelNotLike(String value) {
            addCriterion("usrChannel not like", value, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelIn(List<String> values) {
            addCriterion("usrChannel in", values, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelNotIn(List<String> values) {
            addCriterion("usrChannel not in", values, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelBetween(String value1, String value2) {
            addCriterion("usrChannel between", value1, value2, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andUsrChannelNotBetween(String value1, String value2) {
            addCriterion("usrChannel not between", value1, value2, "usrChannel");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdIsNull() {
            addCriterion("qqOpenId is null");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdIsNotNull() {
            addCriterion("qqOpenId is not null");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdEqualTo(String value) {
            addCriterion("qqOpenId =", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotEqualTo(String value) {
            addCriterion("qqOpenId <>", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdGreaterThan(String value) {
            addCriterion("qqOpenId >", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("qqOpenId >=", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdLessThan(String value) {
            addCriterion("qqOpenId <", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdLessThanOrEqualTo(String value) {
            addCriterion("qqOpenId <=", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdLike(String value) {
            addCriterion("qqOpenId like", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotLike(String value) {
            addCriterion("qqOpenId not like", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdIn(List<String> values) {
            addCriterion("qqOpenId in", values, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotIn(List<String> values) {
            addCriterion("qqOpenId not in", values, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdBetween(String value1, String value2) {
            addCriterion("qqOpenId between", value1, value2, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotBetween(String value1, String value2) {
            addCriterion("qqOpenId not between", value1, value2, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andBeCTimeIsNull() {
            addCriterion("beCTime is null");
            return (Criteria) this;
        }

        public Criteria andBeCTimeIsNotNull() {
            addCriterion("beCTime is not null");
            return (Criteria) this;
        }

        public Criteria andBeCTimeEqualTo(Date value) {
            addCriterion("beCTime =", value, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeNotEqualTo(Date value) {
            addCriterion("beCTime <>", value, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeGreaterThan(Date value) {
            addCriterion("beCTime >", value, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("beCTime >=", value, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeLessThan(Date value) {
            addCriterion("beCTime <", value, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeLessThanOrEqualTo(Date value) {
            addCriterion("beCTime <=", value, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeIn(List<Date> values) {
            addCriterion("beCTime in", values, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeNotIn(List<Date> values) {
            addCriterion("beCTime not in", values, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeBetween(Date value1, Date value2) {
            addCriterion("beCTime between", value1, value2, "beCTime");
            return (Criteria) this;
        }

        public Criteria andBeCTimeNotBetween(Date value1, Date value2) {
            addCriterion("beCTime not between", value1, value2, "beCTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUserTagIsNull() {
            addCriterion("userTag is null");
            return (Criteria) this;
        }

        public Criteria andUserTagIsNotNull() {
            addCriterion("userTag is not null");
            return (Criteria) this;
        }

        public Criteria andUserTagEqualTo(String value) {
            addCriterion("userTag =", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagNotEqualTo(String value) {
            addCriterion("userTag <>", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagGreaterThan(String value) {
            addCriterion("userTag >", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagGreaterThanOrEqualTo(String value) {
            addCriterion("userTag >=", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagLessThan(String value) {
            addCriterion("userTag <", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagLessThanOrEqualTo(String value) {
            addCriterion("userTag <=", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagLike(String value) {
            addCriterion("userTag like", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagNotLike(String value) {
            addCriterion("userTag not like", value, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagIn(List<String> values) {
            addCriterion("userTag in", values, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagNotIn(List<String> values) {
            addCriterion("userTag not in", values, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagBetween(String value1, String value2) {
            addCriterion("userTag between", value1, value2, "userTag");
            return (Criteria) this;
        }

        public Criteria andUserTagNotBetween(String value1, String value2) {
            addCriterion("userTag not between", value1, value2, "userTag");
            return (Criteria) this;
        }

        public Criteria andContactwayIsNull() {
            addCriterion("contactway is null");
            return (Criteria) this;
        }

        public Criteria andContactwayIsNotNull() {
            addCriterion("contactway is not null");
            return (Criteria) this;
        }

        public Criteria andContactwayEqualTo(String value) {
            addCriterion("contactway =", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotEqualTo(String value) {
            addCriterion("contactway <>", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayGreaterThan(String value) {
            addCriterion("contactway >", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayGreaterThanOrEqualTo(String value) {
            addCriterion("contactway >=", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayLessThan(String value) {
            addCriterion("contactway <", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayLessThanOrEqualTo(String value) {
            addCriterion("contactway <=", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayLike(String value) {
            addCriterion("contactway like", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotLike(String value) {
            addCriterion("contactway not like", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayIn(List<String> values) {
            addCriterion("contactway in", values, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotIn(List<String> values) {
            addCriterion("contactway not in", values, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayBetween(String value1, String value2) {
            addCriterion("contactway between", value1, value2, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotBetween(String value1, String value2) {
            addCriterion("contactway not between", value1, value2, "contactway");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdIsNull() {
            addCriterion("sfOpenId is null");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdIsNotNull() {
            addCriterion("sfOpenId is not null");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdEqualTo(String value) {
            addCriterion("sfOpenId =", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdNotEqualTo(String value) {
            addCriterion("sfOpenId <>", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdGreaterThan(String value) {
            addCriterion("sfOpenId >", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("sfOpenId >=", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdLessThan(String value) {
            addCriterion("sfOpenId <", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdLessThanOrEqualTo(String value) {
            addCriterion("sfOpenId <=", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdLike(String value) {
            addCriterion("sfOpenId like", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdNotLike(String value) {
            addCriterion("sfOpenId not like", value, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdIn(List<String> values) {
            addCriterion("sfOpenId in", values, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdNotIn(List<String> values) {
            addCriterion("sfOpenId not in", values, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdBetween(String value1, String value2) {
            addCriterion("sfOpenId between", value1, value2, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfOpenIdNotBetween(String value1, String value2) {
            addCriterion("sfOpenId not between", value1, value2, "sfOpenId");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoIsNull() {
            addCriterion("sfChannelNo is null");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoIsNotNull() {
            addCriterion("sfChannelNo is not null");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoEqualTo(String value) {
            addCriterion("sfChannelNo =", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoNotEqualTo(String value) {
            addCriterion("sfChannelNo <>", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoGreaterThan(String value) {
            addCriterion("sfChannelNo >", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoGreaterThanOrEqualTo(String value) {
            addCriterion("sfChannelNo >=", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoLessThan(String value) {
            addCriterion("sfChannelNo <", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoLessThanOrEqualTo(String value) {
            addCriterion("sfChannelNo <=", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoLike(String value) {
            addCriterion("sfChannelNo like", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoNotLike(String value) {
            addCriterion("sfChannelNo not like", value, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoIn(List<String> values) {
            addCriterion("sfChannelNo in", values, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoNotIn(List<String> values) {
            addCriterion("sfChannelNo not in", values, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoBetween(String value1, String value2) {
            addCriterion("sfChannelNo between", value1, value2, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andSfChannelNoNotBetween(String value1, String value2) {
            addCriterion("sfChannelNo not between", value1, value2, "sfChannelNo");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("LastLoginTime =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("LastLoginTime <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("LastLoginTime >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastLoginTime >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("LastLoginTime <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LastLoginTime <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("LastLoginTime in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("LastLoginTime not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LastLoginTime between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LastLoginTime not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayIsNull() {
            addCriterion("pwdModifyDelay is null");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayIsNotNull() {
            addCriterion("pwdModifyDelay is not null");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayEqualTo(Integer value) {
            addCriterion("pwdModifyDelay =", value, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayNotEqualTo(Integer value) {
            addCriterion("pwdModifyDelay <>", value, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayGreaterThan(Integer value) {
            addCriterion("pwdModifyDelay >", value, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pwdModifyDelay >=", value, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayLessThan(Integer value) {
            addCriterion("pwdModifyDelay <", value, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayLessThanOrEqualTo(Integer value) {
            addCriterion("pwdModifyDelay <=", value, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayIn(List<Integer> values) {
            addCriterion("pwdModifyDelay in", values, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayNotIn(List<Integer> values) {
            addCriterion("pwdModifyDelay not in", values, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayBetween(Integer value1, Integer value2) {
            addCriterion("pwdModifyDelay between", value1, value2, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("pwdModifyDelay not between", value1, value2, "pwdModifyDelay");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeIsNull() {
            addCriterion("pwdModifyTime is null");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeIsNotNull() {
            addCriterion("pwdModifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeEqualTo(Date value) {
            addCriterion("pwdModifyTime =", value, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeNotEqualTo(Date value) {
            addCriterion("pwdModifyTime <>", value, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeGreaterThan(Date value) {
            addCriterion("pwdModifyTime >", value, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pwdModifyTime >=", value, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeLessThan(Date value) {
            addCriterion("pwdModifyTime <", value, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("pwdModifyTime <=", value, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeIn(List<Date> values) {
            addCriterion("pwdModifyTime in", values, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeNotIn(List<Date> values) {
            addCriterion("pwdModifyTime not in", values, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeBetween(Date value1, Date value2) {
            addCriterion("pwdModifyTime between", value1, value2, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andPwdModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("pwdModifyTime not between", value1, value2, "pwdModifyTime");
            return (Criteria) this;
        }

        public Criteria andDealpwdIsNull() {
            addCriterion("dealpwd is null");
            return (Criteria) this;
        }

        public Criteria andDealpwdIsNotNull() {
            addCriterion("dealpwd is not null");
            return (Criteria) this;
        }

        public Criteria andDealpwdEqualTo(String value) {
            addCriterion("dealpwd =", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdNotEqualTo(String value) {
            addCriterion("dealpwd <>", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdGreaterThan(String value) {
            addCriterion("dealpwd >", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdGreaterThanOrEqualTo(String value) {
            addCriterion("dealpwd >=", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdLessThan(String value) {
            addCriterion("dealpwd <", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdLessThanOrEqualTo(String value) {
            addCriterion("dealpwd <=", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdLike(String value) {
            addCriterion("dealpwd like", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdNotLike(String value) {
            addCriterion("dealpwd not like", value, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdIn(List<String> values) {
            addCriterion("dealpwd in", values, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdNotIn(List<String> values) {
            addCriterion("dealpwd not in", values, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdBetween(String value1, String value2) {
            addCriterion("dealpwd between", value1, value2, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andDealpwdNotBetween(String value1, String value2) {
            addCriterion("dealpwd not between", value1, value2, "dealpwd");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceIsNull() {
            addCriterion("bigdataSource is null");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceIsNotNull() {
            addCriterion("bigdataSource is not null");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceEqualTo(String value) {
            addCriterion("bigdataSource =", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceNotEqualTo(String value) {
            addCriterion("bigdataSource <>", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceGreaterThan(String value) {
            addCriterion("bigdataSource >", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("bigdataSource >=", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceLessThan(String value) {
            addCriterion("bigdataSource <", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceLessThanOrEqualTo(String value) {
            addCriterion("bigdataSource <=", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceLike(String value) {
            addCriterion("bigdataSource like", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceNotLike(String value) {
            addCriterion("bigdataSource not like", value, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceIn(List<String> values) {
            addCriterion("bigdataSource in", values, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceNotIn(List<String> values) {
            addCriterion("bigdataSource not in", values, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceBetween(String value1, String value2) {
            addCriterion("bigdataSource between", value1, value2, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceNotBetween(String value1, String value2) {
            addCriterion("bigdataSource not between", value1, value2, "bigdataSource");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeIsNull() {
            addCriterion("bigdataSourceTime is null");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeIsNotNull() {
            addCriterion("bigdataSourceTime is not null");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeEqualTo(String value) {
            addCriterion("bigdataSourceTime =", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeNotEqualTo(String value) {
            addCriterion("bigdataSourceTime <>", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeGreaterThan(String value) {
            addCriterion("bigdataSourceTime >", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("bigdataSourceTime >=", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeLessThan(String value) {
            addCriterion("bigdataSourceTime <", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeLessThanOrEqualTo(String value) {
            addCriterion("bigdataSourceTime <=", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeLike(String value) {
            addCriterion("bigdataSourceTime like", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeNotLike(String value) {
            addCriterion("bigdataSourceTime not like", value, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeIn(List<String> values) {
            addCriterion("bigdataSourceTime in", values, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeNotIn(List<String> values) {
            addCriterion("bigdataSourceTime not in", values, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeBetween(String value1, String value2) {
            addCriterion("bigdataSourceTime between", value1, value2, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andBigdataSourceTimeNotBetween(String value1, String value2) {
            addCriterion("bigdataSourceTime not between", value1, value2, "bigdataSourceTime");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusIsNull() {
            addCriterion("three_verify_status is null");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusIsNotNull() {
            addCriterion("three_verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusEqualTo(Integer value) {
            addCriterion("three_verify_status =", value, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusNotEqualTo(Integer value) {
            addCriterion("three_verify_status <>", value, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusGreaterThan(Integer value) {
            addCriterion("three_verify_status >", value, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("three_verify_status >=", value, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusLessThan(Integer value) {
            addCriterion("three_verify_status <", value, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("three_verify_status <=", value, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusIn(List<Integer> values) {
            addCriterion("three_verify_status in", values, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusNotIn(List<Integer> values) {
            addCriterion("three_verify_status not in", values, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("three_verify_status between", value1, value2, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andThreeVerifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("three_verify_status not between", value1, value2, "threeVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneIsNull() {
            addCriterion("verify_phone is null");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneIsNotNull() {
            addCriterion("verify_phone is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneEqualTo(String value) {
            addCriterion("verify_phone =", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneNotEqualTo(String value) {
            addCriterion("verify_phone <>", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneGreaterThan(String value) {
            addCriterion("verify_phone >", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("verify_phone >=", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneLessThan(String value) {
            addCriterion("verify_phone <", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneLessThanOrEqualTo(String value) {
            addCriterion("verify_phone <=", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneLike(String value) {
            addCriterion("verify_phone like", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneNotLike(String value) {
            addCriterion("verify_phone not like", value, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneIn(List<String> values) {
            addCriterion("verify_phone in", values, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneNotIn(List<String> values) {
            addCriterion("verify_phone not in", values, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneBetween(String value1, String value2) {
            addCriterion("verify_phone between", value1, value2, "verifyPhone");
            return (Criteria) this;
        }

        public Criteria andVerifyPhoneNotBetween(String value1, String value2) {
            addCriterion("verify_phone not between", value1, value2, "verifyPhone");
            return (Criteria) this;
        }
    }

    /**
     * 用户帐号信息userprofile
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 用户帐号信息userprofile的动态SQL对象.
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