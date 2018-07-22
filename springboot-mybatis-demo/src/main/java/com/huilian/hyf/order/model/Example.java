 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.hyf.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 账户资金变动流水 0正常1删除<br/>
 * @author real code generator
 * date:2018-07-23 00:21:47
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
     * 账户资金变动流水amountchangerecord的基本动态SQL对象.
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

        public Criteria andTransactionIDIsNull() {
            addCriterion("TransactionID is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIDIsNotNull() {
            addCriterion("TransactionID is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIDEqualTo(String value) {
            addCriterion("TransactionID =", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualTo(String value) {
            addCriterion("TransactionID <>", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThan(String value) {
            addCriterion("TransactionID >", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualTo(String value) {
            addCriterion("TransactionID >=", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThan(String value) {
            addCriterion("TransactionID <", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualTo(String value) {
            addCriterion("TransactionID <=", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLike(String value) {
            addCriterion("TransactionID like", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotLike(String value) {
            addCriterion("TransactionID not like", value, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDIn(List<String> values) {
            addCriterion("TransactionID in", values, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotIn(List<String> values) {
            addCriterion("TransactionID not in", values, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDBetween(String value1, String value2) {
            addCriterion("TransactionID between", value1, value2, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotBetween(String value1, String value2) {
            addCriterion("TransactionID not between", value1, value2, "transactionID");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("Type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("Type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("Type not between", value1, value2, "type");
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

        public Criteria andChangeAmountIsNull() {
            addCriterion("ChangeAmount is null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNotNull() {
            addCriterion("ChangeAmount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountEqualTo(BigDecimal value) {
            addCriterion("ChangeAmount =", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotEqualTo(BigDecimal value) {
            addCriterion("ChangeAmount <>", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThan(BigDecimal value) {
            addCriterion("ChangeAmount >", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ChangeAmount >=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThan(BigDecimal value) {
            addCriterion("ChangeAmount <", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ChangeAmount <=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIn(List<BigDecimal> values) {
            addCriterion("ChangeAmount in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotIn(List<BigDecimal> values) {
            addCriterion("ChangeAmount not in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ChangeAmount between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ChangeAmount not between", value1, value2, "changeAmount");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createTime");
            return (Criteria) this;
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

        public Criteria andBankCardIsNull() {
            addCriterion("BankCard is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNotNull() {
            addCriterion("BankCard is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardEqualTo(String value) {
            addCriterion("BankCard =", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotEqualTo(String value) {
            addCriterion("BankCard <>", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThan(String value) {
            addCriterion("BankCard >", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("BankCard >=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThan(String value) {
            addCriterion("BankCard <", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThanOrEqualTo(String value) {
            addCriterion("BankCard <=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLike(String value) {
            addCriterion("BankCard like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotLike(String value) {
            addCriterion("BankCard not like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardIn(List<String> values) {
            addCriterion("BankCard in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotIn(List<String> values) {
            addCriterion("BankCard not in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardBetween(String value1, String value2) {
            addCriterion("BankCard between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotBetween(String value1, String value2) {
            addCriterion("BankCard not between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("BankCode is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("BankCode is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("BankCode =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("BankCode <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("BankCode >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BankCode >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("BankCode <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("BankCode <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("BankCode like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("BankCode not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("BankCode in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("BankCode not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("BankCode between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("BankCode not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("ProductId is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("ProductId is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("ProductId =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("ProductId <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("ProductId >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("ProductId >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("ProductId <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("ProductId <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("ProductId like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("ProductId not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("ProductId in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("ProductId not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("ProductId between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("ProductId not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdIsNull() {
            addCriterion("PurchaseRecordId is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdIsNotNull() {
            addCriterion("PurchaseRecordId is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdEqualTo(String value) {
            addCriterion("PurchaseRecordId =", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdNotEqualTo(String value) {
            addCriterion("PurchaseRecordId <>", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdGreaterThan(String value) {
            addCriterion("PurchaseRecordId >", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("PurchaseRecordId >=", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdLessThan(String value) {
            addCriterion("PurchaseRecordId <", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdLessThanOrEqualTo(String value) {
            addCriterion("PurchaseRecordId <=", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdLike(String value) {
            addCriterion("PurchaseRecordId like", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdNotLike(String value) {
            addCriterion("PurchaseRecordId not like", value, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdIn(List<String> values) {
            addCriterion("PurchaseRecordId in", values, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdNotIn(List<String> values) {
            addCriterion("PurchaseRecordId not in", values, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdBetween(String value1, String value2) {
            addCriterion("PurchaseRecordId between", value1, value2, "purchaseRecordId");
            return (Criteria) this;
        }

        public Criteria andPurchaseRecordIdNotBetween(String value1, String value2) {
            addCriterion("PurchaseRecordId not between", value1, value2, "purchaseRecordId");
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

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(Boolean value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(Boolean value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(Boolean value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(Boolean value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<Boolean> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<Boolean> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
            return (Criteria) this;
        }
    }

    /**
     * 账户资金变动流水amountchangerecord
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 账户资金变动流水amountchangerecord的动态SQL对象.
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