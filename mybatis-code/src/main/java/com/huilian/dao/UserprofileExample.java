package com.huilian.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserprofileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserprofileExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andUseridIsNull() {
            addCriterion("UserID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("UserID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("UserID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("UserID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("UserID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("UserID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("UserID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("UserID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("UserID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("UserID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("UserID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("UserID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("UserID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNull() {
            addCriterion("PhoneNum is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("PhoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("PhoneNum =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("PhoneNum <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("PhoneNum >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("PhoneNum >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("PhoneNum <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("PhoneNum <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("PhoneNum like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("PhoneNum not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("PhoneNum in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("PhoneNum not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("PhoneNum between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("PhoneNum not between", value1, value2, "phonenum");
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

        public Criteria andOnlinestatusIsNull() {
            addCriterion("OnlineStatus is null");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusIsNotNull() {
            addCriterion("OnlineStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusEqualTo(String value) {
            addCriterion("OnlineStatus =", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotEqualTo(String value) {
            addCriterion("OnlineStatus <>", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusGreaterThan(String value) {
            addCriterion("OnlineStatus >", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusGreaterThanOrEqualTo(String value) {
            addCriterion("OnlineStatus >=", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusLessThan(String value) {
            addCriterion("OnlineStatus <", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusLessThanOrEqualTo(String value) {
            addCriterion("OnlineStatus <=", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusLike(String value) {
            addCriterion("OnlineStatus like", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotLike(String value) {
            addCriterion("OnlineStatus not like", value, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusIn(List<String> values) {
            addCriterion("OnlineStatus in", values, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotIn(List<String> values) {
            addCriterion("OnlineStatus not in", values, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusBetween(String value1, String value2) {
            addCriterion("OnlineStatus between", value1, value2, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusNotBetween(String value1, String value2) {
            addCriterion("OnlineStatus not between", value1, value2, "onlinestatus");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateIsNull() {
            addCriterion("OnlineStatusUpdate is null");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateIsNotNull() {
            addCriterion("OnlineStatusUpdate is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate =", value, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateNotEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate <>", value, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateGreaterThan(Date value) {
            addCriterion("OnlineStatusUpdate >", value, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateGreaterThanOrEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate >=", value, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateLessThan(Date value) {
            addCriterion("OnlineStatusUpdate <", value, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateLessThanOrEqualTo(Date value) {
            addCriterion("OnlineStatusUpdate <=", value, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateIn(List<Date> values) {
            addCriterion("OnlineStatusUpdate in", values, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateNotIn(List<Date> values) {
            addCriterion("OnlineStatusUpdate not in", values, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateBetween(Date value1, Date value2) {
            addCriterion("OnlineStatusUpdate between", value1, value2, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andOnlinestatusupdateNotBetween(Date value1, Date value2) {
            addCriterion("OnlineStatusUpdate not between", value1, value2, "onlinestatusupdate");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNull() {
            addCriterion("RegDate is null");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNotNull() {
            addCriterion("RegDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegdateEqualTo(Date value) {
            addCriterion("RegDate =", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotEqualTo(Date value) {
            addCriterion("RegDate <>", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThan(Date value) {
            addCriterion("RegDate >", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThanOrEqualTo(Date value) {
            addCriterion("RegDate >=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThan(Date value) {
            addCriterion("RegDate <", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThanOrEqualTo(Date value) {
            addCriterion("RegDate <=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateIn(List<Date> values) {
            addCriterion("RegDate in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotIn(List<Date> values) {
            addCriterion("RegDate not in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateBetween(Date value1, Date value2) {
            addCriterion("RegDate between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotBetween(Date value1, Date value2) {
            addCriterion("RegDate not between", value1, value2, "regdate");
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

        public Criteria andFrozenamountIsNull() {
            addCriterion("FrozenAmount is null");
            return (Criteria) this;
        }

        public Criteria andFrozenamountIsNotNull() {
            addCriterion("FrozenAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenamountEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount =", value, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountNotEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount <>", value, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountGreaterThan(BigDecimal value) {
            addCriterion("FrozenAmount >", value, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount >=", value, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountLessThan(BigDecimal value) {
            addCriterion("FrozenAmount <", value, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FrozenAmount <=", value, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountIn(List<BigDecimal> values) {
            addCriterion("FrozenAmount in", values, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountNotIn(List<BigDecimal> values) {
            addCriterion("FrozenAmount not in", values, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FrozenAmount between", value1, value2, "frozenamount");
            return (Criteria) this;
        }

        public Criteria andFrozenamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FrozenAmount not between", value1, value2, "frozenamount");
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

        public Criteria andDataSourceEqualTo(Short value) {
            addCriterion("data_source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(Short value) {
            addCriterion("data_source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(Short value) {
            addCriterion("data_source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(Short value) {
            addCriterion("data_source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(Short value) {
            addCriterion("data_source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(Short value) {
            addCriterion("data_source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<Short> values) {
            addCriterion("data_source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<Short> values) {
            addCriterion("data_source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(Short value1, Short value2) {
            addCriterion("data_source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(Short value1, Short value2) {
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

        public Criteria andUsrchannelIsNull() {
            addCriterion("usrChannel is null");
            return (Criteria) this;
        }

        public Criteria andUsrchannelIsNotNull() {
            addCriterion("usrChannel is not null");
            return (Criteria) this;
        }

        public Criteria andUsrchannelEqualTo(String value) {
            addCriterion("usrChannel =", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelNotEqualTo(String value) {
            addCriterion("usrChannel <>", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelGreaterThan(String value) {
            addCriterion("usrChannel >", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelGreaterThanOrEqualTo(String value) {
            addCriterion("usrChannel >=", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelLessThan(String value) {
            addCriterion("usrChannel <", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelLessThanOrEqualTo(String value) {
            addCriterion("usrChannel <=", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelLike(String value) {
            addCriterion("usrChannel like", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelNotLike(String value) {
            addCriterion("usrChannel not like", value, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelIn(List<String> values) {
            addCriterion("usrChannel in", values, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelNotIn(List<String> values) {
            addCriterion("usrChannel not in", values, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelBetween(String value1, String value2) {
            addCriterion("usrChannel between", value1, value2, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andUsrchannelNotBetween(String value1, String value2) {
            addCriterion("usrChannel not between", value1, value2, "usrchannel");
            return (Criteria) this;
        }

        public Criteria andQqopenidIsNull() {
            addCriterion("qqOpenId is null");
            return (Criteria) this;
        }

        public Criteria andQqopenidIsNotNull() {
            addCriterion("qqOpenId is not null");
            return (Criteria) this;
        }

        public Criteria andQqopenidEqualTo(String value) {
            addCriterion("qqOpenId =", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotEqualTo(String value) {
            addCriterion("qqOpenId <>", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidGreaterThan(String value) {
            addCriterion("qqOpenId >", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidGreaterThanOrEqualTo(String value) {
            addCriterion("qqOpenId >=", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidLessThan(String value) {
            addCriterion("qqOpenId <", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidLessThanOrEqualTo(String value) {
            addCriterion("qqOpenId <=", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidLike(String value) {
            addCriterion("qqOpenId like", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotLike(String value) {
            addCriterion("qqOpenId not like", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidIn(List<String> values) {
            addCriterion("qqOpenId in", values, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotIn(List<String> values) {
            addCriterion("qqOpenId not in", values, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidBetween(String value1, String value2) {
            addCriterion("qqOpenId between", value1, value2, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotBetween(String value1, String value2) {
            addCriterion("qqOpenId not between", value1, value2, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andBectimeIsNull() {
            addCriterion("beCTime is null");
            return (Criteria) this;
        }

        public Criteria andBectimeIsNotNull() {
            addCriterion("beCTime is not null");
            return (Criteria) this;
        }

        public Criteria andBectimeEqualTo(Date value) {
            addCriterion("beCTime =", value, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeNotEqualTo(Date value) {
            addCriterion("beCTime <>", value, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeGreaterThan(Date value) {
            addCriterion("beCTime >", value, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeGreaterThanOrEqualTo(Date value) {
            addCriterion("beCTime >=", value, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeLessThan(Date value) {
            addCriterion("beCTime <", value, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeLessThanOrEqualTo(Date value) {
            addCriterion("beCTime <=", value, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeIn(List<Date> values) {
            addCriterion("beCTime in", values, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeNotIn(List<Date> values) {
            addCriterion("beCTime not in", values, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeBetween(Date value1, Date value2) {
            addCriterion("beCTime between", value1, value2, "bectime");
            return (Criteria) this;
        }

        public Criteria andBectimeNotBetween(Date value1, Date value2) {
            addCriterion("beCTime not between", value1, value2, "bectime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUsertagIsNull() {
            addCriterion("userTag is null");
            return (Criteria) this;
        }

        public Criteria andUsertagIsNotNull() {
            addCriterion("userTag is not null");
            return (Criteria) this;
        }

        public Criteria andUsertagEqualTo(String value) {
            addCriterion("userTag =", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotEqualTo(String value) {
            addCriterion("userTag <>", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagGreaterThan(String value) {
            addCriterion("userTag >", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagGreaterThanOrEqualTo(String value) {
            addCriterion("userTag >=", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagLessThan(String value) {
            addCriterion("userTag <", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagLessThanOrEqualTo(String value) {
            addCriterion("userTag <=", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagLike(String value) {
            addCriterion("userTag like", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotLike(String value) {
            addCriterion("userTag not like", value, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagIn(List<String> values) {
            addCriterion("userTag in", values, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotIn(List<String> values) {
            addCriterion("userTag not in", values, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagBetween(String value1, String value2) {
            addCriterion("userTag between", value1, value2, "usertag");
            return (Criteria) this;
        }

        public Criteria andUsertagNotBetween(String value1, String value2) {
            addCriterion("userTag not between", value1, value2, "usertag");
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

        public Criteria andSfopenidIsNull() {
            addCriterion("sfOpenId is null");
            return (Criteria) this;
        }

        public Criteria andSfopenidIsNotNull() {
            addCriterion("sfOpenId is not null");
            return (Criteria) this;
        }

        public Criteria andSfopenidEqualTo(String value) {
            addCriterion("sfOpenId =", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidNotEqualTo(String value) {
            addCriterion("sfOpenId <>", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidGreaterThan(String value) {
            addCriterion("sfOpenId >", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidGreaterThanOrEqualTo(String value) {
            addCriterion("sfOpenId >=", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidLessThan(String value) {
            addCriterion("sfOpenId <", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidLessThanOrEqualTo(String value) {
            addCriterion("sfOpenId <=", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidLike(String value) {
            addCriterion("sfOpenId like", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidNotLike(String value) {
            addCriterion("sfOpenId not like", value, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidIn(List<String> values) {
            addCriterion("sfOpenId in", values, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidNotIn(List<String> values) {
            addCriterion("sfOpenId not in", values, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidBetween(String value1, String value2) {
            addCriterion("sfOpenId between", value1, value2, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfopenidNotBetween(String value1, String value2) {
            addCriterion("sfOpenId not between", value1, value2, "sfopenid");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoIsNull() {
            addCriterion("sfChannelNo is null");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoIsNotNull() {
            addCriterion("sfChannelNo is not null");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoEqualTo(String value) {
            addCriterion("sfChannelNo =", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoNotEqualTo(String value) {
            addCriterion("sfChannelNo <>", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoGreaterThan(String value) {
            addCriterion("sfChannelNo >", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoGreaterThanOrEqualTo(String value) {
            addCriterion("sfChannelNo >=", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoLessThan(String value) {
            addCriterion("sfChannelNo <", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoLessThanOrEqualTo(String value) {
            addCriterion("sfChannelNo <=", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoLike(String value) {
            addCriterion("sfChannelNo like", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoNotLike(String value) {
            addCriterion("sfChannelNo not like", value, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoIn(List<String> values) {
            addCriterion("sfChannelNo in", values, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoNotIn(List<String> values) {
            addCriterion("sfChannelNo not in", values, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoBetween(String value1, String value2) {
            addCriterion("sfChannelNo between", value1, value2, "sfchannelno");
            return (Criteria) this;
        }

        public Criteria andSfchannelnoNotBetween(String value1, String value2) {
            addCriterion("sfChannelNo not between", value1, value2, "sfchannelno");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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